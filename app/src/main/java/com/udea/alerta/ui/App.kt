package com.udea.alerta.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.udea.alerta.navigation.Screen
import com.udea.alerta.ui.layout.LayoutMain
import com.udea.alerta.ui.theme.AlertaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class App : ComponentActivity() {

    @ExperimentalPermissionsApi
    @ExperimentalPagerApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlertaTheme {
                val screen = getIntent().getStringExtra("START_DESTINATION")
                    val navController = rememberNavController()
                if (screen != null) {
                    LayoutMain(screen, navController)
                }else{
                    LayoutMain(Screen.GUARDIANES.ruta, navController)
                }
                }

            }
        }

}