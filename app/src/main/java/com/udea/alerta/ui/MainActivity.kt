package com.udea.alerta.ui


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.udea.alerta.alerta.Alerta
import com.udea.alerta.navigation.Screen
import com.udea.alerta.ui.layout.LayoutMain
import com.udea.alerta.ui.theme.AlertaTheme
import com.udea.alerta.viewModel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var splashViewModel: SplashViewModel

    @ExperimentalPermissionsApi
    @ExperimentalPagerApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition {
            !splashViewModel.isLoading.value
        }



        setContent {
            AlertaTheme {
                val screen by splashViewModel.startDestination
                if(screen != Screen.ONBOARDING.ruta){
                    val intent: Intent = Intent(this, Alerta()::class.java)
                    startActivity(intent)
                }else{
                    val navController = rememberNavController()
                    LayoutMain(startDestination = screen, navController)
                }

            }
        }
    }
}












