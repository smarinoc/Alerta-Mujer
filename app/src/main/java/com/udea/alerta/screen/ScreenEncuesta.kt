package com.udea.alerta.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udea.alerta.composables.ButtonBasic
import com.udea.alerta.ui.theme.ColorFont
import com.udea.alerta.ui.theme.ColorPrimario
import com.udea.alerta.ui.theme.ColorTitulo
import com.udea.alerta.ui.theme.Typography


@Composable
fun ScreenEncuesta() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                text = "TEST",
                fontWeight = Typography.h1.fontWeight,
                color = ColorTitulo,
                fontSize = Typography.h1.fontSize,
                textAlign = TextAlign.Center
            )

        }

        items(10) {
            ItemPregunta(
                "¿Cómo sería para ti un día perfecto?"
            )
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
            ButtonBasic(
                text = "TERMINAR", modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .width(150.dp),
                onClick = {}
            )
        }

    }

}

@Composable
fun ItemPregunta(pregunta: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = pregunta,
            fontWeight = FontWeight.Light,
            color = ColorPrimario,
            fontSize = 18.sp,
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = true, onClick = { /*TODO*/ })
            Text(
                modifier = Modifier.padding(horizontal = 20.dp),
                text = "SI",
                fontWeight = Typography.h1.fontWeight,
                color = ColorPrimario,
                fontSize = Typography.h1.fontSize,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(100.dp))
            RadioButton(selected = true, onClick = { /*TODO*/ })
            Text(
                modifier = Modifier.padding(horizontal = 20.dp),
                text = "NO",
                fontWeight = Typography.h1.fontWeight,
                color = ColorPrimario,
                fontSize = Typography.h1.fontSize,
                textAlign = TextAlign.Center
            )


        }


    }



}