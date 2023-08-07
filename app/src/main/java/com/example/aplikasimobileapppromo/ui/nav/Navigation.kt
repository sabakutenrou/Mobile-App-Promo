package com.example.aplikasimobileapppromo.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aplikasimobileapppromo.Constants.Screens.DETAIL_SCREEN
import com.example.aplikasimobileapppromo.Constants.Screens.HOME_SCREEN
import com.example.aplikasimobileapppromo.ui.screens.DetailScreen
import com.example.aplikasimobileapppromo.ui.screens.HomeScreen
import com.example.aplikasimobileapppromo.ui.viewmodel.PromoViewModel

sealed class Screens (val route: String) {

    object Home: Screens(route = HOME_SCREEN)
    object Detail: Screens(route = DETAIL_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController, promoViewModel: PromoViewModel) {

    NavHost(navController = navController, startDestination = Screens.Home.route) {
        composable(route = Screens.Home.route) {
            HomeScreen(promoViewModel = promoViewModel, navController = navController)
        }
        composable(route = Screens.Detail.route + "/{promo}") {
            DetailScreen(id = it.arguments?.getString("promo") ?: "1", promoViewModel = promoViewModel, navController = navController)
        }
    }



}