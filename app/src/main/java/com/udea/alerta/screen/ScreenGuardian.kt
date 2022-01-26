package com.udea.alerta.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.udea.alerta.composables.ButtonBasic
import com.udea.alerta.ui.theme.ColorPrimario
import com.udea.alerta.ui.theme.ColorTitulo
import com.udea.alerta.ui.theme.Typography


@Composable
fun ScreenGuardian() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally


        ) {

        Text(
            text = "GUARDIAN",
            fontWeight = Typography.h1.fontWeight,
            color = ColorTitulo,
            fontSize = Typography.h1.fontSize,
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            , value = "", onValueChange = {}, label = {
            Text(text = "Nombre", color = ColorPrimario)
        },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedLabelColor = ColorPrimario
            )
        )
        TextField(modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            , value = "", onValueChange = {}, label = {
            Text(text = "Numero", color = ColorPrimario)
        },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedLabelColor = ColorPrimario
            )
        )
        
        Box(modifier = Modifier.fillMaxWidth()
            ,contentAlignment = Alignment.Center){
            Row(modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth()
                .height(40.dp),
                horizontalArrangement = Arrangement.Center,
            ){
                ButtonBasic(text = "Guardar", modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .width(150.dp))
                Spacer(modifier = Modifier.width(50.dp))
                ButtonBasic(text = "Eliminar", modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .width(150.dp))
            }
        }}


    }



