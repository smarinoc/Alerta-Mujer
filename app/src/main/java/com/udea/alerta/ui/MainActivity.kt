package com.udea.alerta.ui


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.udea.alerta.alerta.Alerta
import com.udea.alerta.navigation.Screen
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
                val intent: Intent
                if(screen != Screen.ONBOARDING.ruta){
                    intent = Intent(this, Alerta()::class.java)
                    startActivity(intent)
                }else{
                    intent = Intent(this, App()::class.java)
                    intent.putExtra("START_DESTINATION", screen);
                    startActivity(intent)
                }

            }
        }
    }
}












