package com.udea.alerta.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.udea.alerta.composables.Menu
import com.udea.alerta.screen.ScreenAyuda
import com.udea.alerta.screen.ScreenEncuesta
import com.udea.alerta.screen.ScreenGuardian
import com.udea.alerta.screen.ScreenGuardianes
import com.udea.alerta.ui.theme.ColorBackground

@Composable
fun LayoutMain() {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColorBackground)
    ) {
        Menu()
        //ScreenMain()
        ScreenGuardianes()
        //ScreenGuardian()
        //ScreenAyuda()
        //ScreenEncuesta()
    }
}