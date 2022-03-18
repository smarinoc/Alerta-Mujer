package com.udea.alerta.ui.util

import androidx.annotation.DrawableRes
import com.udea.alerta.R


sealed class OnBoardingPage(

    val title: String,
    val description: String,
    val instruction: String
) {
    object First : OnBoardingPage(

        title = "Modo encubierto",
        description = "Modo oculto donde el ingreso a la aplicación está escondido detrás de una calculadora.",
        instruction="Para ingresar a la aplicación presione 3 veces seguidas el botón “/” en la calculadora. "

    )

    object Second : OnBoardingPage(

        title = "Guardiades",
        description = "Guarda y edita a tus contactos que estén dispuestos a ayudarte cuando estés en peligro.",
        instruction="Guarda su nombre y número de teléfono, el mensaje de ayuda llegará vía mensaje de texto a este número."
    )

    object Third : OnBoardingPage(

        title = "Alerta",
        description = "Cuando te sientas en una situación de peligro contarás con un alerta que enviará un mensaje de texto a cada uno de tus guardianes pidiendo ayuda.",
        instruction="Para activar la alerta presiona 3 veces el botón “Clean” en la calculadora."
    )
    object Fourth : OnBoardingPage(

        title = "Directorio de ayudas",
        description = "Directorio de diferentes programas donde podrás recibir acompañamiento y ayuda en casos de violencia de género.",
        instruction="Podrás llamar directamente presionando el botón llamar."
    )

    object Fifth : OnBoardingPage(

        title = "Test de riesgo",
        description = "Podrás llenar un test que medirá los diferentes niveles de riesgo para recibir recomendaciones de acuerdo al nivel.",
        instruction="Responde todas las preguntas y presiona terminar."
    )
}
