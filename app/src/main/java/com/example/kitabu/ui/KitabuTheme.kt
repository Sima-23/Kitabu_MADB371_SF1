package com.example.kitabu.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val KitabuColors =
    lightColorScheme(

        primary = Color(0xFF1B5E20),

        secondary = Color(0xFF388E3C),

        background = Color(0xFFF7F7F2),

        surface = Color.White
    )

@Composable
fun KitabuTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = KitabuColors,
        content = content
    )
}