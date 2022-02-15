package com.udea.alerta.ui.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.udea.alerta.ui.composables.ButtonBasic
import com.udea.alerta.ui.theme.ColorFont
import com.udea.alerta.ui.theme.ColorSegunario
import com.udea.alerta.ui.theme.ColorTitulo
import com.udea.alerta.ui.theme.Typography

@Composable
fun ScreenGuardianes(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 20.dp)
    ) {
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "GUARDIANES",
                fontWeight = Typography.h1.fontWeight,
                color = ColorTitulo,
                fontSize = Typography.h1.fontSize,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        items(5) {
            ItemGuardian("Sara Maria", "3126684942", navController)
        }

        item {
            ButtonBasic(text = "Agregar",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp)),
                onClick = { navController.navigate("GUARDIAN/ & &${true}") })
        }
    }
}

@Composable
fun ItemGuardian(nombre: String, numero: String,navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(ColorSegunario)
            .clickable { navController.navigate("GUARDIAN/${nombre}&${numero}&${false}") },
        horizontalArrangement = Arrangement.SpaceBetween,


    ) {
        Text(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
            text = nombre,
            fontWeight = Typography.body1.fontWeight,
            color = ColorFont,
            fontSize = Typography.body1.fontSize
        )
        Text(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
            text = numero,
            fontWeight = Typography.body1.fontWeight,
            color = ColorFont,
            fontSize = Typography.body1.fontSize
        )
    }
}