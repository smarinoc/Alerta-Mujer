package com.udea.alerta.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.udea.alerta.ui.layout.LayoutMain
import com.udea.alerta.ui.theme.AlertaTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalPermissionsApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlertaTheme {
                // A surface container using the 'background' color from the theme
                LayoutMain()

            }
        }
    }
}


@ExperimentalPermissionsApi
@Preview(
    widthDp = 2160,
    heightDp = 1080,
)
@Composable
fun DefaultPreview() {
    LayoutMain()
}











