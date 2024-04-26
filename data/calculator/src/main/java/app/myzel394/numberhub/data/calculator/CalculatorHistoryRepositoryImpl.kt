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

package app.myzel394.numberhub.data.calculator

import app.myzel394.numberhub.data.database.CalculatorHistoryDao
import app.myzel394.numberhub.data.database.CalculatorHistoryEntity
import app.myzel394.numberhub.data.model.HistoryItem
import app.myzel394.numberhub.data.model.repository.CalculatorHistoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.Date
import javax.inject.Inject

class CalculatorHistoryRepositoryImpl @Inject constructor(
    private val calculatorHistoryDao: CalculatorHistoryDao,
) : CalculatorHistoryRepository {
    /**
     * Calculator history sorted by [CalculatorHistoryEntity.timestamp] from new to old (DESC).
     */
    override val historyFlow: Flow<List<HistoryItem>> = calculatorHistoryDao
        .getAllDescending()
        .map { it.toHistoryItemList() }
        .flowOn(Dispatchers.IO)

    override suspend fun add(
        expression: String,
        result: String,
    ) = withContext(Dispatchers.IO) {
        calculatorHistoryDao.insert(
            CalculatorHistoryEntity(
                timestamp = System.currentTimeMillis(),
                expression = expression,
                result = result,
            ),
        )
    }

    override suspend fun delete(item: HistoryItem) = withContext(Dispatchers.IO) {
        calculatorHistoryDao.delete(item.id)
    }

    override suspend fun clear() = withContext(Dispatchers.IO) {
        calculatorHistoryDao.clear()
    }

    private suspend fun List<CalculatorHistoryEntity>.toHistoryItemList(): List<HistoryItem> = withContext(Dispatchers.Default) {
        this@toHistoryItemList.map {
            HistoryItem(
                id = it.entityId,
                date = Date(it.timestamp),
                expression = it.expression,
                result = it.result,
            )
        }
    }
}
