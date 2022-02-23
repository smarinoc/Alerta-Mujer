package com.udea.alerta.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.SupportAgent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.udea.alerta.data.entities.AyudaEntity
import com.udea.alerta.ui.composables.ButtonBasic
import com.udea.alerta.ui.layout.LayoutScreen
import com.udea.alerta.ui.theme.*
import com.udea.alerta.ui.theme.ColorTitulo
import com.udea.alerta.viewModel.AyudaViewModel

@Composable
fun ScreenAyuda(viewModel: AyudaViewModel = hiltViewModel()) {
    val ayudas by viewModel.ayudas.observeAsState(arrayListOf())
    viewModel.addAyuda(
        AyudaEntity(
            titulo = "Línea 155, Una llamada puede marcar la diferencia",
            descripcion = "Con atención las 24 horas del día, todos los días de la semana, los colombianos podrán comunicarse bajo reserva y gratuitamente a esta línea, desde cualquier operador en todo el territorio nacional para recibir orientación en temas relacionados con violencia de género" +
                    "Personal especializado se encuentra dispuesto para brindar información clara y completa sobre los derechos de las mujeres," +
                    "así como para orientar sobre la forma de hacer una denuncia," +
                    "tipos de violencias de los cuales puede ser víctima una mujer," +
                    "así como procedimientos para obtener atención jurídica y en materia de salud." +
                    "   Del mismo modo," +
                    "quienes se comuniquen podrán conocer la oferta institucional dispuesta por el Gobierno Nacional y los mecanismos en marcha para prevenir," +
                    "minimizar y eliminar las violencias contra las mujeres .", telefono = "155"
        )
    )

    viewModel.addAyuda(
        AyudaEntity(
            titulo = "Línea 123 Mujer",
            descripcion = "La línea 123 Mujer Metropolitana es un mecanismo de atención de emergencias24/7 para mujeres en riesgo o víctimas de violencias con cobertura en nueve municipios del área metropolitana del Valle de Aburrá:\n" +
                    "Barbosa Copacabana Girardota Bello Envigado Caldas Itagüí Sabaneta La Estrella",
            telefono = "123"
        )
    )

    LayoutScreen(title = "AYUDA") {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            contentPadding = PaddingValues(horizontal = 5.dp, vertical = 20.dp)
        ) {

            items(ayudas) { ayudaItem ->
                CardAyuda(ayudaItem);
            }
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
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = ayuda.descripcion,
                style = Typography.body1
            )
            Spacer(modifier = Modifier.height(20.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = ayuda.telefono,
                    style = Typography.h4,

                )
                Icon(
                    imageVector = Icons.Outlined.SupportAgent,
                    contentDescription = null,
                    tint = ColorPrimario
                )
            }


            Spacer(modifier = Modifier.height(10.dp))
            ButtonBasic(
                text = "LLAMAR", modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .fillMaxWidth(), onClick = {}
            )
        }
    }
}


