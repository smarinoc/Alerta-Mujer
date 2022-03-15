package com.udea.alerta.ui.util



sealed class OnBoardingPage(

    val title: String,
    val description: String
) {
    object First : OnBoardingPage(

        title = "Modo encubierto",
        description = "La aplicacion alerta cuenta con un modo encubierto donde el ingreso a la aplicacion esta escodido detras de una calculadora," +
                "se podra ingresar presionando el codigo secreto"
    )

    object Second : OnBoardingPage(

        title = "Boton de panico",
        description = "Mediante otro codigo secreto se podra activar un boton de panico que mandara un mensaje de texto, con un mensaje de ayuda a los respectivos guardines registrados en la aplicacion"
    )

    object Third : OnBoardingPage(

        title = "Guardiades",
        description = "Crear y modifcar a los guardiniades que seran los que resivan el mensaje de texto cuando se activa el boton de manico"
    )
    object Fourth : OnBoardingPage(

        title = "Directorio de Ayudas",
        description = "Lista de ayudas, donde podra resivir atencion, con la opcion de llama directa desde la aplicacion"
    )

    object Fifth : OnBoardingPage(

        title = "Test de medicion de riesgo",
        description = "Test para medir el nivel de risgo en que se encuenta la persona con resultado con recomendaciones"
    )
}
