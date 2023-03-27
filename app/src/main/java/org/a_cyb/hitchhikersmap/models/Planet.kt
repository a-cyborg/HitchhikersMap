@file:Suppress("KDocMissingDocumentation")

package org.a_cyb.hitchhikersmap.models

import androidx.compose.ui.graphics.Color
import com.google.gson.annotations.SerializedName
import org.a_cyb.hitchhikersmap.util.CartesianVector

data class Planet(
    val name: String,
    val color: List<Color>,
    val radius: Float,
    var relativeOffset: CartesianVector,
)


