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

package app.myzel394.numberhub.data.converter.collections

import app.myzel394.numberhub.core.base.MAX_PRECISION
import app.myzel394.numberhub.core.base.R
import app.myzel394.numberhub.data.converter.UnitID
import app.myzel394.numberhub.data.model.converter.UnitGroup
import app.myzel394.numberhub.data.model.converter.unit.BasicUnit
import java.math.BigDecimal
import java.math.RoundingMode

internal val temperatureCollection: List<BasicUnit> by lazy {
    val celsius = object : BasicUnit.Default {
        override val id: String = UnitID.celsius
        override val group: UnitGroup = UnitGroup.TEMPERATURE
        override val displayName: Int = R.string.unit_celsius
        override val shortName: Int = R.string.unit_celsius_short
        override val factor: BigDecimal = BigDecimal.ONE
        override val backward: Boolean = false

        override fun convert(unitTo: BasicUnit.Default, value: BigDecimal): BigDecimal = when (unitTo.id) {
            UnitID.fahrenheit -> {
                value
                    .setScale(MAX_PRECISION, RoundingMode.HALF_EVEN)
                    .times(BigDecimal("1.8"))
                    .plus(BigDecimal("32"))
            }

            UnitID.kelvin -> {
                value
                    .setScale(MAX_PRECISION, RoundingMode.HALF_EVEN)
                    .plus(BigDecimal("273.15"))
            }

            else -> value
        }
    }

    val fahrenheit = object : BasicUnit.Default {
        override val id: String = UnitID.fahrenheit
        override val group: UnitGroup = UnitGroup.TEMPERATURE
        override val displayName: Int = R.string.unit_fahrenheit
        override val shortName: Int = R.string.unit_fahrenheit_short
        override val factor: BigDecimal = BigDecimal.ONE
        override val backward: Boolean = false

        override fun convert(unitTo: BasicUnit.Default, value: BigDecimal): BigDecimal = when (unitTo.id) {
            UnitID.celsius -> {
                value
                    .setScale(MAX_PRECISION, RoundingMode.HALF_EVEN)
                    .minus(BigDecimal("32"))
                    .times(BigDecimal("5"))
                    .div(BigDecimal("9"))
            }
            UnitID.kelvin -> {
                value
                    .setScale(MAX_PRECISION, RoundingMode.HALF_EVEN)
                    .minus(BigDecimal("32"))
                    .times(BigDecimal("5"))
                    .div(BigDecimal("9"))
                    .add(BigDecimal("273.15"))
            }
            else -> value
        }
    }

    val kelvin = object : BasicUnit.Default {
        override val id: String = UnitID.kelvin
        override val group: UnitGroup = UnitGroup.TEMPERATURE
        override val displayName: Int = R.string.unit_kelvin
        override val shortName: Int = R.string.unit_kelvin_short
        override val factor: BigDecimal = BigDecimal.ONE
        override val backward: Boolean = false

        override fun convert(unitTo: BasicUnit.Default, value: BigDecimal): BigDecimal = when (unitTo.id) {
            UnitID.celsius -> {
                value
                    .setScale(MAX_PRECISION, RoundingMode.HALF_EVEN)
                    .minus(BigDecimal("273.15"))
            }
            UnitID.fahrenheit -> {
                value
                    .setScale(MAX_PRECISION, RoundingMode.HALF_EVEN)
                    .minus(BigDecimal("273.15"))
                    .times(BigDecimal("1.8"))
                    .plus(BigDecimal("32"))
            }
            else -> value
        }
    }

    listOf(celsius, fahrenheit, kelvin)
}
