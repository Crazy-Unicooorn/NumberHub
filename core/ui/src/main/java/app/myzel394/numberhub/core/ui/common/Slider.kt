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

package app.myzel394.numberhub.core.ui.common

import androidx.annotation.FloatRange
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.ceil
import kotlin.math.roundToInt

@Composable
fun Slider(
    modifier: Modifier = Modifier,
    value: Float,
    valueRange: ClosedFloatingPointRange<Float>,
    onValueChange: (Float) -> Unit,
    onValueChangeFinished: (Float) -> Unit = {},
) {
    val animated = animateFloatAsState(
        targetValue = value.roundToInt().toFloat(),
        animationSpec = spring(),
        label = "Thumb animation",
    )

    Slider(
        value = animated.value,
        onValueChange = onValueChange,
        modifier = modifier,
        valueRange = valueRange,
        onValueChangeFinished = { onValueChangeFinished(animated.value) },
        track = { sliderPosition -> SquigglyTrack(sliderPosition) },
    )
}

@Composable
private fun SquigglyTrack(
    sliderState: SliderState,
    eachWaveWidth: Float = 80f,
    @FloatRange(0.0, 1.0) waveHeight: Float = 0.7f,
    strokeWidth: Float = 15f,
    filledColor: Color = MaterialTheme.colorScheme.primary,
    unfilledColor: Color = MaterialTheme.colorScheme.surfaceVariant,
) {
    val coroutineScope = rememberCoroutineScope()
    var direct by remember { mutableFloatStateOf(waveHeight * (100f - strokeWidth * 2f) / 100f) }
    val animatedDirect = animateFloatAsState(
        targetValue = direct,
        animationSpec = spring(stiffness = Spring.StiffnessLow),
        label = "Track animation",
    )

    LaunchedEffect(sliderState.value) {
        coroutineScope.launch {
            delay(200L)
            direct *= -1
        }
    }

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(20.dp),
    ) {
        val width = size.width
        val height = size.height
        val initialOffset = strokeWidth / 2
        val thumbPosition = width
            .times(sliderState.value - sliderState.valueRange.start)
            .div(sliderState.valueRange.endInclusive - sliderState.valueRange.start)
            .minus(initialOffset)

        val path = Path().apply {
            moveTo(
                x = initialOffset,
                y = height.times(0.5f),
            )
            val amount = ceil(width.div(eachWaveWidth))

            repeat(amount.toInt()) {
                val peek = if (it % 2 == 0) animatedDirect.value else -animatedDirect.value

                relativeQuadraticBezierTo(
                    dx1 = eachWaveWidth * 0.5f,
                    dy1 = height.times(peek),
                    dx2 = eachWaveWidth,
                    dy2 = 0f,
                )
            }
        }

        clipRect(
            top = 0f,
            left = 0f,
            right = thumbPosition,
            bottom = height,
            clipOp = ClipOp.Intersect,
        ) {
            drawPath(
                path = path,
                color = filledColor,
                style = Stroke(strokeWidth, cap = StrokeCap.Round),
            )
        }

        drawLine(
            color = unfilledColor,
            start = Offset(thumbPosition, height.times(0.5f)),
            end = Offset(width, height.times(0.5f)),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round,
        )
    }
}

@Preview(device = "spec:width=411dp,height=891dp")
@Preview(device = "spec:width=673.5dp,height=841dp,dpi=480")
@Preview(device = "spec:width=1280dp,height=800dp,dpi=480")
@Preview(device = "spec:width=1920dp,height=1080dp,dpi=480")
@Composable
private fun PreviewNewSlider() {
    var currentValue by remember { mutableFloatStateOf(9f) }

    app.myzel394.numberhub.core.ui.common.Slider(
        value = currentValue,
        valueRange = 0f..16f,
        onValueChange = { currentValue = it },
    )
}
