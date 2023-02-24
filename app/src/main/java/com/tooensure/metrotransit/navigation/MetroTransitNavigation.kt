package com.tooensure.metrotransit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tooensure.metrotransit.screens.MetroTransitSplashScreen
import com.tooensure.metrotransit.screens.cart.Cart
import com.tooensure.metrotransit.screens.home.HomeScreen
import com.tooensure.metrotransit.views.account.createAccountView
import com.tooensure.metrotransit.views.account.retrieveAccountView


@Composable
fun MetroTransitNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MetroTransitScreens.SplashScreen.name) {
        //
        composable(MetroTransitScreens.SplashScreen.name) {
            MetroTransitSplashScreen(navController = navController)
        }
        //
        composable(
            MetroTransitScreens.SignInScreen.name) {
            retrieveAccountView(navController = navController)
        }
        //
        composable(
            MetroTransitScreens.SignUpScreen.name) {
            createAccountView(navController = navController)
        }
        //
        composable(
            MetroTransitScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        //
        composable(
            MetroTransitScreens.MetroTransitCartScreen.name) {
            Cart(navController = navController)
        }
    }
}