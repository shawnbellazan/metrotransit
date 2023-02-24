package com.tooensure.metrotransit.navigation

enum class MetroTransitScreens {
    SplashScreen,
    SignInScreen,
    SignUpScreen,
    HomeScreen,
    MetroTransitCartScreen,
    DetailScreen;

    companion object {
        fun fromRoute(route:String?) : MetroTransitScreens =
            when(route?.substringBefore("/"))
            {
                SplashScreen.name -> SplashScreen
                SignInScreen.name -> SignInScreen
                SignUpScreen.name -> SignUpScreen
                HomeScreen.name -> HomeScreen
                MetroTransitCartScreen.name -> MetroTransitCartScreen
                DetailScreen.name -> DetailScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognized")
            }
    }
}