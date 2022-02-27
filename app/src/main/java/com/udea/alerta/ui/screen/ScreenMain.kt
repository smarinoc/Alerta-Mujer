package com.udea.alerta.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
            modifier = Modifier.padding(vertical = 10.dp)
        )

        Button(
            modifier = Modifier
                .size(300.dp)
                .clip(CircleShape),
            onClick = { println("other message")},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)

        ) {
            Text(text = "Alerta", color = Color.Yellow, fontSize = 50.sp)


        }


    }
}