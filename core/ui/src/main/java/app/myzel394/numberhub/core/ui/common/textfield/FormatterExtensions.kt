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

package app.myzel394.numberhub.core.ui.common.textfield

import app.myzel394.numberhub.core.base.FormatterSymbols
import app.myzel394.numberhub.core.base.Token

private val numbersRegex by lazy { Regex("[\\d.]+") }

/**
 * Removes formatting from expression. Reverse of [formatExpression]. Ugly symbols (for example,
 * minus) will be replaced with a [Token.Operator.minus] from [Token.sexyToUgly].
 *
 * @param formatterSymbols [FormatterSymbols] that were used in [formatExpression].
 * @return Clean expression. 123,456.789 -> 123456.789
 */
fun String.clearAndFilterExpression(formatterSymbols: FormatterSymbols): String {
    var clean = this
        .replace(formatterSymbols.grouping, "")
        .replace(formatterSymbols.fractional, Token.Digit.dot)
        .replace(" ", Token.Operator.plus)
        .replace(Token.DisplayOnly.fraction, Token.Operator.divide)

    Token.sexyToUgly.forEach { (token, ugliness) ->
        ugliness.forEach {
            clean = clean.replace(it, token)
        }
    }

    return clean.leaveLegalTokensOnly(Token.expressionTokens)
}

internal fun String.clearAndFilterNumberBase(): String {
    return uppercase().leaveLegalTokensOnly(Token.numberBaseTokens)
}

fun String.formatExpression(
    formatterSymbols: FormatterSymbols,
): String {
    var input = this

    // Fractional
    if (input.contains(Token.DisplayOnly.fraction)) {
        // Only format integral part
        val splitFractional = input.split(" ")
        if (splitFractional.size > 1) {
            return "${splitFractional[0].formatNumber(formatterSymbols)} ${splitFractional[1]}"
        }
        // No integral part
        return input
    }

    numbersRegex
        .findAll(input)
        .map(MatchResult::value)
        .forEach {
            input = input.replace(it, it.formatNumber(formatterSymbols))
        }

    // Replace ugly symbols
    Token.sexyToUgly.forEach { (token, uglySymbols) ->
        uglySymbols.forEach { uglySymbol ->
            input = input.replace(uglySymbol, token)
        }
    }

    return input
}

private fun String.formatNumber(
    formatterSymbols: FormatterSymbols,
): String {
    val input = this

    if (input.any { it.isLetter() }) return input

    var firstPart = input.takeWhile { it != '.' }
    val remainingPart = input.removePrefix(firstPart)

    // Number of empty symbols (spaces) we need to add to correctly split into chunks.
    val offset = 3 - firstPart.length.mod(3)
    val output = if (offset != 3) {
        // We add some spaces at the beginning so that last chunk has 3 symbols
        firstPart = " ".repeat(offset) + firstPart
        firstPart.chunked(3).joinToString(formatterSymbols.grouping).drop(offset)
    } else {
        firstPart.chunked(3).joinToString(formatterSymbols.grouping)
    }

    return output.plus(remainingPart.replace(".", formatterSymbols.fractional))
}

private fun String.leaveLegalTokensOnly(legalTokens: List<String>): String {
    val streamOfTokens = this

    fun peekTokenAfter(cursor: Int): String? {
        legalTokens.forEach { token ->
            val subs = streamOfTokens
                .substring(
                    cursor,
                    (cursor + token.length).coerceAtMost(streamOfTokens.length),
                )
            if (subs == token) {
                // Got a digit, see if there are other digits coming after
                if (token in Token.Digit.allWithDot) {
                    return streamOfTokens
                        .substring(cursor)
                        .takeWhile { Token.Digit.allWithDot.contains(it.toString()) }
                }
                return token
            }
        }
        return null
    }

    var cursor = 0
    var tokens = ""

    while (cursor != streamOfTokens.length) {
        val nextToken = peekTokenAfter(cursor)

        if (nextToken != null) {
            tokens += nextToken
            cursor += nextToken.length
        } else {
            // Didn't find any token, move left slowly (by 1 symbol)
            cursor++
        }
    }

    return tokens
}
