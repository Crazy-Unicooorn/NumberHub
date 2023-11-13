/*
 * Unitto is a unit converter for Android
 * Copyright (c) 2023 Elshan Agaev
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.sadellie.unitto.feature.calculator

import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sadellie.unitto.core.base.Token
import com.sadellie.unitto.core.ui.common.textfield.AllFormatterSymbols
import com.sadellie.unitto.core.ui.common.textfield.addBracket
import com.sadellie.unitto.core.ui.common.textfield.addTokens
import com.sadellie.unitto.core.ui.common.textfield.deleteTokens
import com.sadellie.unitto.core.ui.common.textfield.getTextField
import com.sadellie.unitto.data.common.isExpression
import com.sadellie.unitto.data.common.setMinimumRequiredScale
import com.sadellie.unitto.data.common.stateIn
import com.sadellie.unitto.data.common.toStringWith
import com.sadellie.unitto.data.common.trimZeros
import com.sadellie.unitto.data.model.repository.CalculatorHistoryRepository
import com.sadellie.unitto.data.model.repository.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.sadellie.evaluatto.Expression
import io.github.sadellie.evaluatto.ExpressionException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject

@HiltViewModel
internal class CalculatorViewModel @Inject constructor(
    private val userPrefsRepository: UserPreferencesRepository,
    private val calculatorHistoryRepository: CalculatorHistoryRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _inputKey = "CALCULATOR_INPUT"
    private val _input = MutableStateFlow(savedStateHandle.getTextField(_inputKey))
    private val _result = MutableStateFlow<CalculationResult>(CalculationResult.Empty)
    private val _equalClicked = MutableStateFlow(false)
    private val _prefs = userPrefsRepository.calculatorPrefs
        .stateIn(viewModelScope, null)
    private var _fractionJob: Job? = null

    val uiState: StateFlow<CalculatorUIState> = combine(
        _input,
        _result,
        _prefs,
        calculatorHistoryRepository.historyFlow,
    ) { input, result, prefs, history ->
        prefs ?: return@combine CalculatorUIState.Loading

        return@combine CalculatorUIState.Ready(
            input = input,
            output = result,
            radianMode = prefs.radianMode,
            precision = prefs.precision,
            outputFormat = prefs.outputFormat,
            formatterSymbols = AllFormatterSymbols.getById(prefs.separator),
            history = history,
            allowVibration = prefs.enableVibrations,
            middleZero = prefs.middleZero,
            acButton = prefs.acButton,
            partialHistoryView = prefs.partialHistoryView,
        )
    }
        .mapLatest { ui ->
            if (ui !is CalculatorUIState.Ready) return@mapLatest ui
            if (_equalClicked.value) return@mapLatest ui

            if (!ui.input.text.isExpression()) {
                _result.update { CalculationResult.Empty }
                return@mapLatest ui
            }

            _result.update {
                try {
                    CalculationResult.Default(
                        calculate(
                            input = ui.input.text,
                            radianMode = ui.radianMode,
                        )
                            .setMinimumRequiredScale(ui.precision)
                            .trimZeros()
                            .toStringWith(ui.outputFormat)
                    )
                } catch (e: ExpressionException.DivideByZero) {
                    CalculationResult.Empty
                } catch (e: Exception) {
                    CalculationResult.Empty
                }
            }

            ui
        }
        .stateIn(viewModelScope, CalculatorUIState.Loading)

    fun addTokens(tokens: String) = _input.update {
        val newValue = if (_equalClicked.value) {
            _equalClicked.update { false }
            TextFieldValue().addTokens(tokens)
        } else {
            it.addTokens(tokens)
        }
        _fractionJob?.cancel()
        savedStateHandle[_inputKey] = newValue.text
        newValue
    }

    fun addBracket() = _input.update {
        val newValue = if (_equalClicked.value) {
            _equalClicked.update { false }
            TextFieldValue().addBracket()
        } else {
            it.addBracket()
        }
        _fractionJob?.cancel()
        savedStateHandle[_inputKey] = newValue.text
        newValue
    }

    fun deleteTokens() = _input.update {
        val newValue = if (_equalClicked.value) {
            _equalClicked.update { false }
            TextFieldValue().deleteTokens()
        } else {
            it.deleteTokens()
        }
        _fractionJob?.cancel()
        savedStateHandle[_inputKey] = newValue.text
        newValue
    }

    fun clearInput() = _input.update {
        _equalClicked.update { false }
        _fractionJob?.cancel()
        savedStateHandle[_inputKey] = ""
        TextFieldValue()
    }

    fun onCursorChange(selection: TextRange) = _input.update { it.copy(selection = selection) }

    fun updateRadianMode(newValue: Boolean) = viewModelScope.launch {
        userPrefsRepository.updateRadianMode(newValue)
    }

    fun clearHistory() = viewModelScope.launch(Dispatchers.IO) {
        calculatorHistoryRepository.clear()
    }

    fun evaluate() = viewModelScope.launch {
        val prefs = _prefs.value ?: return@launch
        if (_equalClicked.value) return@launch
        if (!_input.value.text.isExpression()) return@launch

        val result = try {
            calculate(_input.value.text, prefs.radianMode, RoundingMode.DOWN)
        } catch (e: ExpressionException.DivideByZero) {
            _equalClicked.update { true }
            _result.update { CalculationResult.DivideByZeroError }
            return@launch
        } catch (e: ExpressionException.FactorialCalculation) {
            _equalClicked.update { true }
            _result.update { CalculationResult.Error }
            return@launch
        } catch (e: Exception) {
            _equalClicked.update { true }
            _result.update { CalculationResult.Error }
            return@launch
        }

        _equalClicked.update { true }

        val resultFormatted = result
            .setMinimumRequiredScale(prefs.precision)
            .trimZeros()
            .toStringWith(prefs.outputFormat)

        withContext(Dispatchers.IO) {
            calculatorHistoryRepository.add(
                expression = _input.value.text.replace("-", Token.Operator.minus),
                result = resultFormatted
            )
        }

        _fractionJob?.cancel()
        _fractionJob = launch(Dispatchers.Default) {
            val fraction = result.toFractionalString()

            _input.update { TextFieldValue(resultFormatted, TextRange(resultFormatted.length)) }
            _result.update { CalculationResult.Fraction(fraction) }
        }
    }

    private suspend fun calculate(
        input: String,
        radianMode: Boolean,
        roundingMode: RoundingMode = RoundingMode.HALF_EVEN,
    ): BigDecimal = withContext(Dispatchers.Default) {
        Expression(input, radianMode, roundingMode)
            .calculate()
            .also {
                if (it > BigDecimal.valueOf(Double.MAX_VALUE)) throw ExpressionException.TooBig()
            }
    }
}
