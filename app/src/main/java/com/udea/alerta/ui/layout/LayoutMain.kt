package com.udea.alerta.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.udea.alerta.ui.composables.Menu
import com.udea.alerta.ui.screen.*
import com.udea.alerta.ui.theme.ColorBackground

sealed class Screen(val ruta: String) {
    object MAIN : Screen("ALERTA")
    object GUARDIANES : Screen("GUARDIANES")
    object GUARDIAN : Screen("GUARDIAN")
    object AYUDA : Screen("AYUDA")
    object ENCUESTA : Screen("TEST")
}


@Composable
fun LayoutMain() {
    val navController = rememberNavController()

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColorBackground)
    ) {
        Menu(navController)
        NavHost(navController = navController, startDestination = Screen.MAIN.ruta) {
            composable(Screen.MAIN.ruta) { ScreenMain() }
            composable(Screen.GUARDIANES.ruta) { ScreenGuardianes(navController) }
            composable(
                route = "${Screen.GUARDIAN.ruta}/{nombre}&{numero}&{nuevo}",
                arguments = listOf(navArgument("nuevo") {
                    type = NavType.BoolType
                })
            )
            { backStackEntry ->
                val nombre = backStackEntry.arguments?.getString("nombre")
                val numero = backStackEntry.arguments?.getString("numero")
                val nuevo = backStackEntry.arguments?.getBoolean("nuevo")
                ScreenGuardian(nombre = nombre!!, numero = numero!!, nuevo = nuevo!!)
            }
            composable(Screen.AYUDA.ruta) { ScreenAyuda() }
            composable(Screen.ENCUESTA.ruta) { ScreenEncuesta() }

        }
    }
}