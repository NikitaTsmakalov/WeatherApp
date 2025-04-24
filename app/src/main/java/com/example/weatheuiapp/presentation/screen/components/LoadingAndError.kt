package com.example.weatheuiapp.presentation.screen.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun LoadingAndError(error: String?, isLoading: Boolean, modifier: Modifier = Modifier) {
    if (error != null) {
        Text(
            text = "Ошибка: $error",
            modifier = modifier,
            color = Color.White,
            fontSize = 20.sp
        )
    } else if (isLoading) {
        Text(
            text = "Загрузка...",
            modifier = modifier,
            color = Color.White,
            fontSize = 20.sp
        )
    }
}