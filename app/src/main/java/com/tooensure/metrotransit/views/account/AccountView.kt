package com.tooensure.metrotransit.views.account

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.lifecycle.LiveData
import com.tooensure.metrotransit.components.SubmitButton
import com.tooensure.metrotransit.ui.field.EmailPasswordComponent
import com.tooensure.metrotransit.ui.field.InputField

@Composable
fun AccountView(content: @Composable () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {
            content()
        }
    }
}



@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun retrieveAccountForm(
    loading: MutableState<Boolean>,
    email: MutableState<String> = rememberSaveable() { mutableStateOf("") },
    password: MutableState<String> = rememberSaveable() { mutableStateOf("") },
    onDone: (String, String) -> Unit,
)
{
    val keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current

    EmailPasswordComponent(loading.value, email, password)
    SubmitButton(
        textId = "Sign In",
        loading = loading.value,
        validInputs = true
    ) {

        onDone(email.value.trim(), password.value.trim())
        loading.value = true
        keyboardController?.hide()
    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun createAccountForm(
    loading: MutableState<Boolean>,
    email: MutableState<String> = rememberSaveable() { mutableStateOf("") },
    password: MutableState<String> = rememberSaveable() { mutableStateOf("") },
    onDone: (String, String) -> Unit
)
{
    val confirmPassword: MutableState<String> = rememberSaveable() { mutableStateOf("") }
    val keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current

    EmailPasswordComponent(loading.value,email,password)
    InputField(
        label = "Confirm Password",
        input = confirmPassword,
        onAction = KeyboardActions {

        },
    )

    SubmitButton(
        textId = "Sign Up",
        loading = loading.value,
        validInputs = true
    ) {

        Log.d("TAG", "SignUpForm: ${confirmPassword.value} ${password.value} ${email.value}")
        onDone(email.value.trim(), password.value.trim())
        if (password.value != confirmPassword.value) return@SubmitButton
        else loading.value = true
        keyboardController?.hide()
    }

}