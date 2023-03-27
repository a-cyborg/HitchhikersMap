package org.a_cyb.hitchhikersmap.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ThreeDRotationController(modifier: Modifier, isActive: Boolean) {
    val colorBrush: Brush
    val alpha: Float
    val iconEmoji: String = "👁"

    if (isActive) {
        colorBrush = Brush.radialGradient(
            listOf(
                Color.Red,
                Color(0xFF3DEF23),
                MaterialTheme.colors.background
            )
        )
        alpha = 0.5f
//        iconEmoji = "🧿"
    } else {
        colorBrush = Brush.radialGradient(
            listOf(
                Color(0xFF68FDE5),
                Color.LightGray,
                MaterialTheme.colors.background
            )
        )
        alpha = 0.8f
//        iconEmoji = "👁"
    }

    Text(
        modifier = modifier
            .background(colorBrush, CircleShape)
            .padding(18.dp) // Padding
            .alpha(alpha),
        text = iconEmoji,
        fontSize = 23.sp
    )
}
