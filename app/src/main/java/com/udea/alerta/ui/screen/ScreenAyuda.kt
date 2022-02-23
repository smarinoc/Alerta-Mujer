package com.udea.alerta.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.udea.alerta.data.entities.AyudaEntity
import com.udea.alerta.data.entities.GuardianEntity
import com.udea.alerta.ui.composables.ButtonBasic
import com.udea.alerta.ui.theme.*
import com.udea.alerta.ui.theme.ColorTitulo
import com.udea.alerta.viewModel.AyudaViewModel
import com.udea.alerta.viewModel.GuardianViewModel

@Composable
fun ScreenAyuda(viewModel: AyudaViewModel = hiltViewModel()) {
    val ayudas by viewModel.ayudas.observeAsState(arrayListOf())
    viewModel.addAyuda(
        AyudaEntity(
            titulo = "Línea 155, Una llamada puede marcar la diferencia",
            descripcion = "Con atención las 24 horas del día, todos los días de la semana, los colombianos podrán comunicarse bajo reserva y gratuitamente a esta línea, desde cualquier operador en todo el territorio nacional para recibir orientación en temas relacionados con violencia de género"+
            "Personal especializado se encuentra dispuesto para brindar información clara y completa sobre los derechos de las mujeres,"+
            "así como para orientar sobre la forma de hacer una denuncia,"+
            "tipos de violencias de los cuales puede ser víctima una mujer,"+
            "así como procedimientos para obtener atención jurídica y en materia de salud."+
            "   Del mismo modo,"+
            "quienes se comuniquen podrán conocer la oferta institucional dispuesta por el Gobierno Nacional y los mecanismos en marcha para prevenir,"+
            "minimizar y eliminar las violencias contra las mujeres .", telefono = "155")
    )

    viewModel.addAyuda(
        AyudaEntity(
            titulo = "Línea 123 Mujer",
            descripcion = "La línea 123 Mujer Metropolitana es un mecanismo de atención de emergencias24/7 para mujeres en riesgo o víctimas de violencias con cobertura en nueve municipios del área metropolitana del Valle de Aburrá:\n" +
                    "Barbosa Copacabana Girardota Bello Envigado Caldas Itagüí Sabaneta La Estrella", telefono = "123")
    )





    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 20.dp)
    ) {
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "AYUDA",
                fontWeight = Typography.h1.fontWeight,
                color = ColorTitulo,
                fontSize = Typography.h1.fontSize,
                textAlign = TextAlign.Center
            )

        }

        items(ayudas) { ayudaItem ->
            CardAyuda(ayudaItem);
        }
    }
}


@Composable
fun CardAyuda(ayuda: AyudaEntity) {
    Card() {
        Column(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = ayuda.titulo,
                style = Typography.h2
            )

            Text(
                text = ayuda.descripcion,
            )

            Text(
                text = ayuda.telefono,
            )

            ButtonBasic(
                text = "LLAMAR", modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .fillMaxWidth(), onClick = {}
            )
        }
    }
}


