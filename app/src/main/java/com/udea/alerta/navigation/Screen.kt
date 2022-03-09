package com.udea.alerta.navigation

sealed class Screen(val ruta: String) {
    object GUARDIANES : Screen("GUARDIANES")
    object GUARDIAN : Screen("GUARDIAN")
    object AYUDA : Screen("AYUDA")
    object ENCUESTA : Screen("TEST")
    object PERFILRIESGO : Screen("RIESGO")
    object ONBOARDING: Screen("ONBOARDING")
}