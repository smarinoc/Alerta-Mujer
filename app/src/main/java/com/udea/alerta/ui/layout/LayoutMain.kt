package com.udea.alerta.ui.layout

import androidx.compose.animation.ExperimentalAnimationApi
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.udea.alerta.navigation.NavGraph
import com.udea.alerta.navigation.Screen
import com.udea.alerta.ui.composables.Tabs
import com.udea.alerta.ui.theme.ColorBackground



@ExperimentalAnimationApi
@ExperimentalPagerApi
@ExperimentalPermissionsApi
@Composable
fun LayoutMain(startDestination: String, navController: NavHostController,) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Alerta") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }, actions = {
                    IconButton(onClick = { navController.navigate(Screen.ONBOARDING.ruta)}) {
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
            NavGraph(navController, startDestination)

        }
    }
}