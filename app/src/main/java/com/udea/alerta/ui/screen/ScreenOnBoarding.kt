package com.udea.alerta.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.*
import com.udea.alerta.navigation.Screen
import com.udea.alerta.ui.composables.ButtonBasic
import com.udea.alerta.ui.layout.LayoutScreen
import com.udea.alerta.ui.theme.Typography
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
        OnBoardingPage.Third,
        OnBoardingPage.Fourth,
        OnBoardingPage.Fifth
    )
    val pagerState = rememberPagerState()
    OnBoardingViewModel.saveOnBoardingState(completed = true)

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = 5,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position], position = position, onClick = {

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

    LayoutScreen(title = onBoardingPage.title) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight(0.7f),
                painter = painterResource(id = onBoardingPage.image),
                contentDescription = "Pager Image"
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .padding(top = 20.dp),
                text = onBoardingPage.description,
                style = Typography.body1
            )

            if (position == 4) {
                ButtonBasic(text = "Empezar", onClick = onClick, modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp).padding(horizontal = 20.dp))
            }
        }
    }

}
