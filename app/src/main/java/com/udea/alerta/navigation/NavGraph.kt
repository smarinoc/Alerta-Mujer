package com.udea.alerta.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.udea.alerta.ui.screen.*

@ExperimentalPermissionsApi
@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(navController = navController, startDestination = startDestination) {
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
        composable(Screen.ONBOARDING.ruta){ ScreenOnBoarding(navController = navController) }

    }
}