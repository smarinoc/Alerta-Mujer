package com.udea.alerta.ui.screen


import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.udea.alerta.data.entities.GuardianEntity
import com.udea.alerta.ui.composables.TextFieldGuardian
import com.udea.alerta.ui.layout.LayoutScreen
import com.udea.alerta.viewModel.GuardianViewModel


@Composable
fun ScreenGuardian(
    id: Int = -1,
    nombreP: String = "",
    numeroP: String = "",
    nuevo: Boolean = true,
    navController: NavController,
    viewModel: GuardianViewModel = hiltViewModel()
) {

    var nombre = rememberSaveable { mutableStateOf(nombreP) }
    var numero = rememberSaveable { mutableStateOf(numeroP) }
    val focusManager = LocalFocusManager.current

    fun onSubmit() {
        if (nuevo) {
            viewModel.addGuardian(GuardianEntity(nombre = nombre.value, numero = numero.value))
        } else {
            viewModel.updateGuardian(
                GuardianEntity(
                    id = id,
                    nombre = nombre.value,
                    numero = numero.value
                )
            )
        }
        navController.popBackStack()
    }

    LayoutScreen(title = "GUARDIAN") {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally,


            ) {
            TextFieldGuardian(
                value = nombre,
                label = "Nombre",
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                )
            )
            TextFieldGuardian(
                value = numero,
                label = "Número",
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Done,
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                    }

                )
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
                    ButtonBasic(
                        text = "Guardar",
                        modifier = Modifier.width(150.dp),
                        onClick = { onSubmit() })
                    ButtonBasic(
                        text = "Cancelar",
                        modifier = Modifier.width(150.dp),
                        onClick = { navController.popBackStack() })

                }
            }
        }

    }

}




