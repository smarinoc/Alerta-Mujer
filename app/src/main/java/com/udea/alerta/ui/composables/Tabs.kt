package com.udea.alerta.ui.composables

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material.icons.outlined.Shield
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import java.io.Console


@Composable
fun Tabs(navController: NavHostController) {
    var state by rememberSaveable { mutableStateOf(0) }
    TabRow(selectedTabIndex = state) {
        TabBox(
            title = "GUARDIANES", selected = state == 0,
            onClick = {
                state=0
                navController.navigate("GUARDIANES") },
            imageVector = Icons.Outlined.Shield
        )
        TabBox(
            title = "AYUDA",
            selected = state == 1,
            onClick = {
                state=1
                navController.navigate("AYUDA") },
            imageVector = Icons.Outlined.HelpOutline
        )
        TabBox(
            title = "TEST",
            selected = state == 2,
            onClick = {
                state=2
                navController.navigate("TEST") },
            imageVector = Icons.Outlined.Quiz
        )
    }
}

@Composable
fun TabBox(title: String, selected: Boolean, onClick: () -> Unit, imageVector: ImageVector) {
    Tab(selected = selected,
        onClick = { onClick() },
        text = {
            Text(
                text = title,
                maxLines = 1,
                softWrap = false,
                overflow = TextOverflow.Ellipsis
            )
        },
        icon = { Icon(imageVector = imageVector, contentDescription = null) }
    )
}





