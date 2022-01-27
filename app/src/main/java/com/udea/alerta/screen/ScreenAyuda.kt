package com.udea.alerta.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.udea.alerta.composables.ButtonBasic
import com.udea.alerta.ui.theme.*
import com.udea.alerta.ui.theme.ColorTitulo

@Preview
@Composable
fun ScreenAyuda() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                text = "AYUDA",
                fontWeight = Typography.h1.fontWeight,
                color = ColorTitulo,
                fontSize = Typography.h1.fontSize,
                textAlign = TextAlign.Center
            )

        }

        items(2) {
            ItemAyuda(
                "Sara Maria",
                "3126684942",
                "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original."
            )
        }
    }
}


@Composable
fun ItemAyuda(nombre: String, numero: String, descripcion: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .background(ColorSegunario, RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = nombre,
            fontWeight = Typography.h1.fontWeight,
            color = ColorFont,
            fontSize = Typography.h1.fontSize,
        )

        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = descripcion,
            fontWeight = FontWeight.Light,
            color = ColorFont,
            fontSize = 18.sp,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(

                text = numero,
                fontWeight = Typography.h1.fontWeight,
                color = ColorFont,
                fontSize = Typography.h1.fontSize
            )

            ButtonBasic(
                text = "LLAMAR", modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .width(150.dp), onClick = {}
            )
        }
    }

}
