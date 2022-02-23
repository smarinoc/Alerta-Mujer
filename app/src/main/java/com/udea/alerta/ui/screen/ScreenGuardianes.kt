package com.udea.alerta.ui.screen


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.udea.alerta.data.entities.GuardianEntity
import com.udea.alerta.ui.composables.ButtonBasic
import com.udea.alerta.ui.theme.*
import com.udea.alerta.viewModel.GuardianViewModel


@Composable
fun ScreenGuardianes(
    navController: NavHostController,
    viewModel: GuardianViewModel = hiltViewModel()
) {
    val guardianes by viewModel.guardianes.observeAsState(arrayListOf())

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
                style = Typography.h1
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        items(guardianes) { guardian ->
            ListItemGuardian(guardian, navController);
        }

        item {
            ButtonBasic(text = "Agregar",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                onClick = { navController.navigate("GUARDIAN/ & & &${true}") })
        }
    }
}


@Composable
fun ListItemGuardian(
    guardian: GuardianEntity,
    navController: NavHostController,
    viewModel: GuardianViewModel = hiltViewModel()

) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = ColorSegunario,
        shape = Shapes.large

    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
                Text(text = guardian.nombre, style = Typography.h3)
                Text(text = guardian.numero, style = Typography.subtitle1)

            }

            Row() {
                IconButton(onClick = { navController.navigate("GUARDIAN/${guardian.id}&${guardian.nombre}&${guardian.numero}&${false}") }) {
                    Icon(Icons.Outlined.Edit, contentDescription = null, tint = Color.White)
                }
                IconButton(onClick = { viewModel.deleteGuardian(guardian) }) {
                    Icon(Icons.Outlined.Delete, contentDescription = null, tint = Color.White)
                }

            }
        }
    }

}