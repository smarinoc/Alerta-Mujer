package com.udea.alerta.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.udea.alerta.ui.composables.Menu
import com.udea.alerta.ui.composables.Tabs
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
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Alerta") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                })

        }
    ) { padding ->


        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .background(color = ColorBackground)
                .padding(padding)
        ) {
            Tabs(navController = navController)
            NavHost(navController = navController, startDestination = Screen.GUARDIANES.ruta) {
                composable(Screen.MAIN.ruta) { ScreenMain() }
                composable(Screen.GUARDIANES.ruta) { ScreenGuardianes(navController) }
                composable(
                    route = "${Screen.GUARDIAN.ruta}/{id}&{nombre}&{numero}&{nuevo}",
                    arguments = listOf(navArgument("nuevo") {
                        type = NavType.BoolType
                    }, navArgument("id"){
                        type = NavType.IntType
                    })
                )
                { backStackEntry ->
                    val id = backStackEntry.arguments?.getInt("id")
                    val nombre = backStackEntry.arguments?.getString("nombre")
                    val numero = backStackEntry.arguments?.getString("numero")
                    val nuevo = backStackEntry.arguments?.getBoolean("nuevo")
                    ScreenGuardian(
                        id = id!!,
                        nombreP = nombre!!,
                        numeroP = numero!!,
                        nuevo = nuevo!!,
                        navController
                    )
                }
                composable(Screen.AYUDA.ruta) { ScreenAyuda() }
                composable(Screen.ENCUESTA.ruta) { ScreenTest() }

            }

        }
    }
}