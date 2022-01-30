package com.udea.alerta.composables

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Menu(navController: NavHostController) {
    var thisScreen by rememberSaveable { mutableStateOf("ALERTA") }
    var primerBtn by rememberSaveable { mutableStateOf("GUARDIANES") }
    var segundoBtn by rememberSaveable { mutableStateOf("AYUDA") }
    var ultimoBtn by rememberSaveable { mutableStateOf("TEST") }
   
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier

            .fillMaxWidth()
            .requiredHeight(height = 70.dp)
            .padding(horizontal = 2.dp, vertical = 10.dp)
    ) {
        ButtonBasic(text = primerBtn, modifier = Modifier.weight(1f),
            onClick = {
                navController.navigate(primerBtn)
                var aux: String = primerBtn
                primerBtn = thisScreen
                thisScreen = aux
            })
        ButtonBasic(text = segundoBtn, modifier = Modifier.weight(1f), onClick = {
            navController.navigate(segundoBtn)
            var aux: String = segundoBtn
            segundoBtn = thisScreen
            thisScreen = aux
        })
        ButtonBasic(text = ultimoBtn, modifier = Modifier.weight(1f), onClick = {
            navController.navigate(ultimoBtn)
            var aux: String = ultimoBtn
            ultimoBtn = thisScreen
            thisScreen = aux
        })
    }

}

