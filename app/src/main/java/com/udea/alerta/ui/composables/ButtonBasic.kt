package com.udea.alerta.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.udea.alerta.ui.theme.Shapes
import com.udea.alerta.ui.theme.Typography

@Composable
fun ButtonBasic(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        contentPadding = PaddingValues(horizontal = 1.dp, vertical = 10.dp),
        modifier=modifier,
        shape = Shapes.large,
        onClick = onClick
    ) {
        Text(
            text = text, style = Typography.h3

        )
    }
}