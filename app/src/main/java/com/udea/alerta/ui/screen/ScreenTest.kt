package com.udea.alerta.ui.screen


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.udea.alerta.data.entities.PreguntaEntity
import com.udea.alerta.ui.composables.ButtonBasic
import com.udea.alerta.ui.layout.LayoutScreen
import com.udea.alerta.viewModel.PreguntaViewModel

var puntajes = Array(23) { 0 }

@Composable
fun ScreenTest(navController: NavController) {
    var startTest = rememberSaveable { mutableStateOf(false) }

    LayoutScreen(title = "TEST") {
        if (startTest.value) {
            QuestionList(navController = navController)
        } else {
            InfoTest(onClick = {startTest.value=true})
        }
    }
}

@Composable
fun InfoTest(onClick: ()-> Unit) {
    Card(modifier = Modifier.padding(horizontal = 5.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp)) {
            Text(text = "Este test evaluará el nivel de riesgo.", style = typography.body1.copy(textAlign = TextAlign.Center ))
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Sólo es válido para mujeres mayores de edad.", style = typography.body1.copy(textAlign = TextAlign.Center))
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Derechos reservados", style = typography.subtitle1.copy(color = Color.Black))
            Spacer(modifier = Modifier.height(10.dp))
            ButtonBasic(text = "Empezar test", onClick = onClick, modifier = Modifier.fillMaxWidth())
        }
    }

}


@SuppressLint("UnrememberedMutableState")
@Composable
fun QuestionList(navController: NavController, viewModel: PreguntaViewModel = hiltViewModel()) {

    val preguntas by viewModel.preguntas.observeAsState(arrayListOf())
    var changeListQuestion = rememberSaveable { mutableStateOf(false) }

    fun calcularRiesgo() {
        var suma = 0
        puntajes.forEach {
            suma = suma + it
        }
        if (suma < 8) {
            navController.navigate("RIESGO/${1}")
            return
        } else {
            if (suma < 14) {
                navController.navigate("RIESGO/${2}")
                return
            } else {
                if (suma < 18) {
                    navController.navigate("RIESGO/${3}")
                    return
                } else {
                    navController.navigate("RIESGO/${4}")
                    return
                }
            }
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(bottom = 20.dp, start = 5.dp, end = 5.dp)
    ) {


        items(preguntas) { preguntaItem ->
            changeListQuestion.value
            if (preguntaItem.depende == -1) {
                CardPregunta(
                    preguntaItem,
                    changeListQuestion = changeListQuestion
                )
            } else {
                if (puntajes[preguntaItem.id - 2] != 0) {
                    CardPregunta(
                        preguntaItem,
                        changeListQuestion = changeListQuestion
                    )
                }
            }

        }
        item {

            ButtonBasic(
                text = "Terminar",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                onClick = {
                    calcularRiesgo()

                }
            )
        }
    }

}


@Composable
fun CardPregunta(
    pregunta: PreguntaEntity,
    changeListQuestion: MutableState<Boolean>,
) {

    Card(modifier = Modifier.padding(top = 5.dp)) {
        val radioOptions = listOf("Sí", "No")
        val (selectedOption, onOptionSelected) = rememberSaveable { mutableStateOf("") }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = pregunta.pregunta,
                style = typography.h2,
                modifier = Modifier.padding(top = 10.dp)
            )
            Row(
                Modifier
                    .selectableGroup()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                radioOptions.forEach { text ->
                    Row(
                        Modifier
                            .height(56.dp)
                            .selectable(
                                selected = (text == selectedOption),
                                onClick = {
                                    onOptionSelected(text)
                                    if (text == "Sí") {
                                        puntajes[pregunta.id - 1] = pregunta.puntaje

                                    } else {
                                        puntajes[pregunta.id - 1] = 0
                                    }
                                    changeListQuestion.value = changeListQuestion.value.not()
                                },
                                role = Role.RadioButton
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (text == selectedOption),
                            onClick = null
                        )
                        Text(
                            text = text,
                            style = typography.h2,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }

        }

    }

}






