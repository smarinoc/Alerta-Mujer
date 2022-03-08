package com.udea.alerta.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.udea.alerta.ui.composables.Tabs
import com.udea.alerta.ui.screen.*
import com.udea.alerta.ui.theme.ColorBackground

sealed class Screen(val ruta: String) {
    object GUARDIANES : Screen("GUARDIANES")
    object GUARDIAN : Screen("GUARDIAN")
    object AYUDA : Screen("AYUDA")
    object ENCUESTA : Screen("TEST")
    object PERFILRIESGO : Screen("RIESGO")
    object ONBOARDING: Screen("ONBOARDING")
}

@ExperimentalPagerApi
@ExperimentalPermissionsApi
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
                }, actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Info, contentDescription = null)
                    }
                }
            )

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
            NavHost(navController = navController, startDestination = Screen.ONBOARDING.ruta) {
                composable(Screen.GUARDIANES.ruta) { ScreenGuardianes(navController) }
                composable(
                    route = "${Screen.GUARDIAN.ruta}/{id}&{nombre}&{numero}&{nuevo}",
                    arguments = listOf(navArgument("nuevo") {
                        type = NavType.BoolType
                    }, navArgument("id") {
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
                composable(Screen.ENCUESTA.ruta) { ScreenTest(navController) }
                composable(
                    route = "${Screen.PERFILRIESGO.ruta}/{aux}",
                    arguments = listOf(navArgument("aux") {
                        type = NavType.IntType
                    })
                )
                { backStackEntry ->
                    val aux = backStackEntry.arguments?.getInt("aux")
                    ScreenPerfilRiesgo(aux = aux!!)
                }
                composable(Screen.ONBOARDING.ruta){ ScreenOnBoarding(navController = navController)}

            }

        }
    }
}