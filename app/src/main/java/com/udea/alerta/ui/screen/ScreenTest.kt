package com.udea.alerta.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udea.alerta.ui.composables.ButtonBasic
import com.udea.alerta.ui.layout.LayoutScreen
import com.udea.alerta.ui.theme.ColorPrimario
import com.udea.alerta.ui.theme.ColorTitulo
import com.udea.alerta.ui.theme.Typography


@Composable
fun ScreenTest() {
    LayoutScreen(title = "TEST") {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            items(10) {
                CardPregunta(
                    "¿Cómo sería para ti un día perfecto?"
                )
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
                ButtonBasic(
                    text = "TERMINAR", modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .width(200.dp)
                        .padding(bottom = 60.dp),
                    onClick = {}
                )
            }

        }

    }


}

@Composable
fun CardPregunta(pregunta: String) {

    Card() {

    }

}






