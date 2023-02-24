package com.tooensure.metrotransit.screens.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
private fun HomeScreenContainer(content: @Composable () -> Unit)
{
    content()
}

@Composable
fun HomeScreen(navController: NavController)
{
    Text(text = "Home Screen")
}