package com.udea.alerta.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.udea.alerta.ui.theme.ColorFont
import com.udea.alerta.ui.theme.ColorPrimario
import com.udea.alerta.ui.theme.Typography

@Composable
fun ButtonBasic(text: String, modifier: Modifier, onClick: ()-> Unit) {
    Button(
        contentPadding= PaddingValues(horizontal = 1.dp),
        modifier = modifier
            .padding(horizontal = 1.dp)
            .background(ColorPrimario)
            .fillMaxHeight(),
         onClick = onClick
        //contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontWeight = Typography.body1.fontWeight,
            color = ColorFont,
            fontSize = Typography.body1.fontSize
        )
    }
}