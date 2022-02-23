package com.udea.alerta.ui.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.udea.alerta.ui.composables.ButtonBasic
import com.udea.alerta.ui.theme.ColorTitulo
import com.udea.alerta.ui.theme.Typography
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.udea.alerta.data.entities.GuardianEntity
import com.udea.alerta.viewModel.GuardianViewModel


@Composable
fun ScreenGuardian(
    id: Int = -1,
    nombre: String = "",
    numero: String = "",
    nuevo: Boolean = true,
    navController: NavController,
    viewModel: GuardianViewModel = hiltViewModel()
) {
    var nombre by rememberSaveable { mutableStateOf(nombre) }
    var numero by rememberSaveable { mutableStateOf(numero) }


    fun add() {
        viewModel.addGuardian(GuardianEntity(nombre = nombre, numero = numero))
    }

    fun update() {
        viewModel.updateGuardian(GuardianEntity(id = id, nombre = nombre, numero = numero))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 5.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {

        Text(
            text = "GUARDIAN",
            fontWeight = Typography.h1.fontWeight,
            color = ColorTitulo,
            fontSize = Typography.h1.fontSize,
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = {
                Text(text = "Nombre")
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = numero,
            onValueChange = { numero = it },
            label = {
                Text(text = "Numero")
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Box(
            modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                ButtonBasic(text = "Guardar", modifier = Modifier.width(150.dp), onClick = {
                    if (nuevo) {
                        add()
                    } else {
                        update()
                    }
                    navController.popBackStack()
                })
                ButtonBasic(text = "Cancelar",modifier = Modifier.width(150.dp), onClick = { navController.popBackStack() })

            }
        }
    }


}



