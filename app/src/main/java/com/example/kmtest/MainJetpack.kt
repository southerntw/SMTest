package com.example.kmtest

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.kmtest.ui.navigation.Screen
import com.example.kmtest.ui.screen.first.FirstScreen
import com.example.kmtest.ui.screen.third.ThirdScreen
import com.example.kmtest.ui.screen.second.SecondScreen
import com.example.kmtest.ui.viewmodel.AppViewModel

@Composable
fun MainJetpack(modifier: Modifier = Modifier,
                navController: NavHostController = rememberNavController()
) {
    val viewModel: AppViewModel = hiltViewModel(LocalContext.current as ComponentActivity)

    NavHost(
        navController = navController,
        startDestination = Screen.First.route,
        modifier = modifier
    ) {


        composable(Screen.First.route) {
            FirstScreen(onNextClicked = {
                navController.navigate(Screen.Second.route)
            }, viewModel = viewModel)
        }

        composable(Screen.Second.route) {
            SecondScreen(onChooseClicked = {
                navController.navigate(Screen.Third.route)
            }, onBackClicked = {
                navController.navigateUp()
            }, viewModel = viewModel)
        }

        composable(Screen.Third.route) {
            ThirdScreen(onBackClicked = {
                navController.navigateUp()
            }, viewModel = viewModel)
        }
    }
}