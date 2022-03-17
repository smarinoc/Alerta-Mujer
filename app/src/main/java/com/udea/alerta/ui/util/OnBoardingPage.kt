package com.udea.alerta.ui.util

import androidx.annotation.DrawableRes
import com.udea.alerta.R


sealed class OnBoardingPage(

    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingPage(
        image = R.drawable.imagen_1,
        title = "Modo encubierto",
        description = "La aplicacion alerta cuenta con un modo encubierto donde el ingreso a la aplicacion esta escodido detras de una calculadora," +
                "se podra ingresar presionando el codigo secreto"
    )

    object Second : OnBoardingPage(
        image = R.drawable.imagen_1,
        title = "Boton de panico",
        description = "Mediante otro codigo secreto se podra activar un boton de panico que mandara un mensaje de texto, con un mensaje de ayuda a los respectivos guardines registrados en la aplicacion"
    )

    object Third : OnBoardingPage(
        image = R.drawable.imagen_1,
        title = "Guardiades",
        description = "Crear y modifcar a los guardiniades que seran los que resivan el mensaje de texto cuando se activa el boton de manico"
    )
    object Fourth : OnBoardingPage(
        image = R.drawable.imagen_1,
        title = "Directorio de Ayudas",
        description = "Lista de ayudas, donde podra resivir atencion, con la opcion de llama directa desde la aplicacion"
    )

    object Fifth : OnBoardingPage(
        image = R.drawable.imagen_1,
        title = "Test de medicion de riesgo",
        description = "Test para medir el nivel de risgo en que se encuenta la persona con resultado con recomendaciones"
    )
}
