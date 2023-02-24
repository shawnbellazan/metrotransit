package com.tooensure.metrotransit.views.account

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController
import com.tooensure.metrotransit.components.MetroTransitLogoText
import com.tooensure.metrotransit.components.NavButton
import com.tooensure.metrotransit.components.globalScale
import com.tooensure.metrotransit.navigation.MetroTransitScreens

@Composable
fun retrieveAccountView(
    navController: NavController,
    viewModel: AccountViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val loading = rememberSaveable() { mutableStateOf(false) }
    AccountView {
        MetroTransitLogoText(scale = globalScale)

        retrieveAccountForm(loading) { _email, _password ->
            viewModel.signInWithEmailAndPassword(_email,_password) {
                navController.navigate(MetroTransitScreens.HomeScreen.name)
            }
        }

        NavButton(text = "new user?", textBtn = "Sign Up") {
            navController.navigate(MetroTransitScreens.SignUpScreen.name)
        }
    }
}