/*
 * Unitto is a calculator for Android
 * Copyright (c) 2023-2024 Elshan Agaev
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

package app.myzel394.numberhub.feature.timezone

import android.icu.util.TimeZone
import android.icu.util.ULocale
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.myzel394.numberhub.data.common.stateIn
import app.myzel394.numberhub.data.model.timezone.SearchResultZone
import app.myzel394.numberhub.data.timezone.TimeZonesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.N)
@HiltViewModel
class AddTimeZoneViewModel @Inject constructor(
    private val timezonesRepository: TimeZonesRepository,
) : ViewModel() {
    private val query = MutableStateFlow(TextFieldValue())
    private val result = MutableStateFlow(emptyList<SearchResultZone>())

    val uiState = combine(
        query,
        result,
        timezonesRepository.favoriteTimeZones,
    ) { query, result, _ ->
        return@combine AddTimeZoneUIState.Ready(
            query = query,
            list = result,
        )
    }
        .mapLatest { ui ->
            viewModelScope.launch {
                result.update {
                    timezonesRepository.filter(
                        searchQuery = ui.query.text,
                        locale = ULocale.forLanguageTag(
                            AppCompatDelegate.getApplicationLocales().toLanguageTags(),
                        ),
                    )
                }
            }
            ui
        }
        .stateIn(viewModelScope, AddTimeZoneUIState.Loading)

    fun onQueryChange(textFieldValue: TextFieldValue) = query.update { textFieldValue }

    fun addToFavorites(timeZone: TimeZone) = viewModelScope.launch {
        timezonesRepository.addToFavorites(timeZone)
    }
}
