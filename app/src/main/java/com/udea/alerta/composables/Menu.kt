package com.udea.alerta.composables

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Menu() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(height = 55.dp)
            .padding(all = 2.dp)
    ) {
        ButtonBasic(text = "GUARDIANES", modifier = Modifier.weight(1f))
        ButtonBasic(text = "AYUDA", modifier = Modifier.weight(1f))
        ButtonBasic(text = "TEST", modifier = Modifier.weight(1f))
    }

}