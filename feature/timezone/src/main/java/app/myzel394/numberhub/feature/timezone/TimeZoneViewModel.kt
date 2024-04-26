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
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.myzel394.numberhub.data.common.stateIn
import app.myzel394.numberhub.data.model.timezone.FavoriteZone
import app.myzel394.numberhub.data.timezone.TimeZonesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.ZonedDateTime
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.N)
@HiltViewModel
internal class TimeZoneViewModel @Inject constructor(
    private val timezonesRepository: TimeZonesRepository,
) : ViewModel() {
    private val userTimeZone = MutableStateFlow(TimeZone.getDefault())
    private val customUserTime = MutableStateFlow<ZonedDateTime?>(null)
    private val selectedTimeZone = MutableStateFlow<FavoriteZone?>(null)
    private val dialogState = MutableStateFlow<TimeZoneDialogState>(TimeZoneDialogState.Nothing)

    val uiState = combine(
        customUserTime,
        userTimeZone,
        selectedTimeZone,
        dialogState,
        timezonesRepository.favoriteTimeZones,
    ) { customUserTime, userTimeZone, selectedTimeZone, dialogState, favoriteTimeZones ->
        return@combine TimeZoneUIState.Ready(
            favorites = favoriteTimeZones,
            customUserTime = customUserTime,
            userTimeZone = userTimeZone,
            selectedTimeZone = selectedTimeZone,
            dialogState = dialogState,
        )
    }
        .stateIn(viewModelScope, TimeZoneUIState.Loading)

    fun setCurrentTime() = customUserTime.update { null }

    fun setSelectedTime(time: ZonedDateTime) = customUserTime.update { time }

    fun setDialogState(state: TimeZoneDialogState) = dialogState.update { state }

    fun onDragEnd(
        tz: FavoriteZone,
        targetPosition: Int,
    ) = viewModelScope.launch {
        timezonesRepository.moveTimeZone(tz, targetPosition)
    }

    fun delete(timeZone: FavoriteZone) = viewModelScope.launch {
        timezonesRepository.removeFromFavorites(timeZone)
    }

    fun selectTimeZone(timeZone: FavoriteZone?) = selectedTimeZone.update { timeZone }

    fun updateLabel(
        timeZone: FavoriteZone,
        label: String,
    ) = viewModelScope.launch {
        timezonesRepository.updateLabel(timeZone = timeZone, label = label)
    }
}
