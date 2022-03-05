package com.udea.alerta.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.udea.alerta.ui.layout.LayoutScreen
import com.udea.alerta.ui.theme.Typography


@Composable
fun ScreenPerfilRiesgo(
    aux: Int
) {
    Card(modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
        LazyColumn() {
            item {

                when (aux) {
                    1 -> {
                        LayoutScreen(title = "RIESGO VARIABLE") {
                            Text(
                                text = "• En caso de reincidencia del agresor, no dude en acudir inmediatamente a la autoridad competente (Comisaria de Familia).\n\n" +
                                        "• Acate la medida de protección que le haya sido otorgada.\n\n" +
                                        "• Evite espacios de confrontación con su agresor. Si este llegare a molestarla, no lo desafié, no entre en disputas con él, no se deje provocar. Mantenga una actitud de calma.\n\n" +
                                        "• Observe su conducta y esté atenta a comportamientos y actitudes inusuales de su parte.\n\n" +
                                        "• Asista cumplidamente a las citas que le asignen los profesionales de apoyo en caso de que se las dieran, e invítelo a él a asistir si le fueron asignadas. De no contar con este recurso cuando puso su demanda, busque apoyo emocional en un profesional.",
                                style = Typography.body1,
                                modifier = Modifier.padding(
                                    end = 5.dp,
                                    start = 5.dp,
                                    bottom = 10.dp
                                )
                            )
                        }
                    }
                    2 -> {
                        LayoutScreen(title = "PELIGRIO MODERADO") {
                            Text(
                                text = "• En caso de reincidencia del agresor, no dude en acudir inmediatamente a la autoridad competente (Comisaria de Familia)\n\n" +
                                        "• Acate la medida de protección que le fue otorgada. \n\n" +
                                        "• Mantenga una actitud vigilante. Si observa en él una conducta violenta (patadas, gritos, insultos, malos tratos, etc.) aléjese inmediatamente y llame a las autoridades. No lo desafié pero intente defenderse si llegara a usar la fuerza.\n\n" +
                                        "• Mantenga una maleta lista con sus pertenencias más necesarias por si debe salir de su residencia y teléfonos de personas cercanas o instancias de protección como el 123 Mujer\n\n" +
                                        "• Revise y/o vigile que su pareja no tenga armas de fuego o corto punzantes.",
                                style = Typography.body1,
                                modifier = Modifier.padding(
                                    end = 5.dp,
                                    start = 5.dp,
                                    bottom = 10.dp
                                )
                            )
                        }
                    }
                    3 -> {
                        LayoutScreen(title = "PELIGRO GRAVE") {
                            Text(
                                text = "• Por ningún motivo establezca contacto telefónico o físico con su agresor. Cambie su número telefónico si utiliza celular.\n\n" +
                                        "• Haga cumplir la medida de protección que le fue otorgada y si su agresor la incumple no dude en acudir inmediatamente a las autoridades.\n\n" +
                                        "• No frecuente sitios donde él se mantenga y en caso de encontrárselo casualmente o de que la esté rondando, recurra a su red de apoyo y/o a las autoridades para que puedan brindarle compañía y protección.\n\n" +
                                        "• No le abra la puerta de su residencia y si este llegare hasta el sitio donde usted se encuentra, busque como salir sin que la vea.\n\n" +
                                        "• Mantenga sus documentos  a la mano y los de sus hijos e hijas menores.\n\n" +
                                        "• Mantenga una maleta lista con sus pertenencias más necesarias por si debe salir de su residencia y teléfonos de personas cercanas o instancias de protección como el 123.\n\n" +
                                        "• Mantenga una actitud vigilante.\n\n" +
                                        "• Si su casa no es segura y el agresor tiene acceso a ella, desaloje y acuda a su red de apoyo. Sino cuenta con ésta, llame inmediatamente  sepa de su presencia y pida protección para que la remitan a un  hogar de acogida.",
                                style = Typography.body1,
                                modifier = Modifier.padding(
                                    end = 5.dp,
                                    start = 5.dp,
                                    bottom = 10.dp
                                )
                            )
                        }
                    }
                    4 -> {
                        LayoutScreen(title = "RIESGO EXTREMO") {
                            Text(
                                text = "• Cambie de residencia.\n\n" +
                                        "• Si el agresor no tiene orden de desalojo, pida a las personas encargadas de su protección que la acompañen por sus pertenencias\n\n" +
                                        "• Mantenga una actitud vigilante y a mano los números telefónicos de las autoridades.\n\n" +
                                        "• Por ningún motivo establezca ningún tipo de contacto con su agresor.\n\n" +
                                        "• No se acerque a ningún lugar que frecuenta su pareja o expareja.\n\n" +
                                        "• Asista a todas las citas que le fueron asignadas tanto por las autoridades como por los profesionales de apoyo (médicos, sicólogos, abogados, etc.) y cuando se desplase hágalo siempre acompañada de una autoridad competente o de los profesionales que le estén brindando protección.\n\n" +
                                        "• No de sus datos a nadie, no diga donde se aloja. Si tiene que hacer una llamada urgente, hágalo desde un teléfono público.",
                                style = Typography.body1,
                                modifier = Modifier.padding(
                                    end = 5.dp,
                                    start = 5.dp,
                                    bottom = 10.dp
                                )
                            )
                        }
                    }

                }
            }

        }
    }
}