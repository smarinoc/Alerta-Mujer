package com.udea.alerta.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.*
import com.udea.alerta.navigation.Screen
import com.udea.alerta.ui.composables.ButtonBasic
import com.udea.alerta.ui.util.OnBoardingPage
import com.udea.alerta.viewModel.OnBoardingViewModel

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun ScreenOnBoarding(
    navController: NavHostController,
    OnBoardingViewModel: OnBoardingViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerState = rememberPagerState()

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = 3,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position], position = position, onClick = {

                OnBoardingViewModel.saveOnBoardingState(completed = true)
                navController.popBackStack()
                navController.navigate(Screen.GUARDIANES.ruta)
            })

        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f),
            pagerState = pagerState
        )

    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage, position: Int, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = onBoardingPage.title,

            )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .padding(top = 20.dp),
            text = onBoardingPage.description,

            )

        if (position == 2) {
            ButtonBasic(text = "Terminar", onClick = onClick)
        }

    }
}
