package com.udea.alerta.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.udea.alerta.ui.theme.Typography

@Composable
fun LayoutScreen(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 20.dp
                ),
            text = title,
            style = Typography.h1
        )
        Column(content = content, modifier = Modifier.padding(top = 10.dp))
    }
}