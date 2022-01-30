package com.udea.alerta


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.udea.alerta.layout.LayoutMain
import com.udea.alerta.ui.theme.AlertaTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlertaTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LayoutMain()
                }
            }
        }
    }
}


@Preview(
    widthDp = 2160,
    heightDp = 1080,
)
@Composable
fun DefaultPreview() {
    LayoutMain()
}












