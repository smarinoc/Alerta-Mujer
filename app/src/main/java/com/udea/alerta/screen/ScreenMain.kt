package com.udea.alerta.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScreenMain() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Presionar 2 veces",
            fontSize = 20.sp,
            modifier = Modifier.padding(vertical = 5.dp)
        )
        Box(
            modifier = Modifier

                .size(200.dp)
                .clip(CircleShape)
                .background(Color.Red),
            contentAlignment = Alignment.Center

        ) {
            Text(text = "Alerta", color = Color.Yellow, fontSize = 50.sp)
        }
    }
}