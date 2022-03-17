package com.udea.alerta.ui.screen


import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.SupportAgent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.udea.alerta.data.entities.AyudaEntity
import com.udea.alerta.ui.composables.ButtonBasic
import com.udea.alerta.ui.layout.LayoutScreen
import com.udea.alerta.ui.theme.*
import com.udea.alerta.viewModel.AyudaViewModel
import com.google.accompanist.permissions.rememberPermissionState


@ExperimentalPermissionsApi
@Composable
fun ScreenAyuda(viewModel: AyudaViewModel = hiltViewModel()) {
    val ayudas by viewModel.ayudas.observeAsState(arrayListOf())
    val permissionState = rememberPermissionState(android.Manifest.permission.CALL_PHONE)
    val context = LocalContext.current


    LayoutScreen(title = "AYUDA") {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            contentPadding = PaddingValues(bottom = 20.dp, start = 5.dp, end = 5.dp)
        ) {

            items(ayudas) { ayudaItem ->
                CardAyuda(ayudaItem, permissionState, context);
            }
        }

    }
}

@ExperimentalPermissionsApi
@Composable
fun CardAyuda(ayuda: AyudaEntity, permissionState: PermissionState, context: Context) {
    Card() {
        Column(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = ayuda.titulo,
                style = Typography.h2
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = ayuda.descripcion,
                style = Typography.body1
            )
            Spacer(modifier = Modifier.height(20.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = ayuda.telefono,
                    style = Typography.h4,

                    )
                Icon(
                    imageVector = Icons.Outlined.SupportAgent,
                    contentDescription = null,
                    tint = ColorPrimario
                )
            }


            Spacer(modifier = Modifier.height(10.dp))
            ButtonBasic(
                text = "LLAMAR", modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .fillMaxWidth(), onClick = {

                    if (permissionState.hasPermission) {
                        context.startActivity(
                            Intent(
                                Intent(
                                    Intent.ACTION_CALL,
                                    Uri.parse("tel:${ayuda.telefono}")
                                )
                            )
                        )

                    } else {
                        permissionState.launchPermissionRequest()
                    }


                }
            )
        }


    }
}


