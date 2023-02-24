package com.tooensure.metrotransit.ui.field

import android.util.Log
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.lifecycle.LiveData

@Composable
fun EmailPasswordField(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    email: MutableState<String>,
    password: MutableState<String>,
    passwordFocus: FocusRequester = FocusRequester.Default,
    showPassword: MutableState<Boolean> = rememberSaveable() { mutableStateOf(false) },
    // Dry Code duplicate within onPasswordAction
    onEmailAction: KeyboardActions = KeyboardActions(onNext = {
        Log.d("ACCT", "EmailPasswordField: Email Action")
        passwordFocus.requestFocus()
    }),
    onPasswordAction: KeyboardActions = KeyboardActions(onNext = {
        Log.d("ACCT", "EmailPasswordField: Password Fired")
    }),
    ) {

    EmailField(
        modifier = Modifier,
        isEnabled = isEnabled,
        state = email,
        label = "email",
        imeAction = ImeAction.Next,
        onImeAction = onEmailAction
    )

    PasswordField(
        modifier = Modifier.focusRequester(passwordFocus),
        isEnabled = isEnabled,
        state = password,
        visual = showPassword,
        imeAction = ImeAction.Next,
        onImeAction = onPasswordAction
    )
}


@Composable
fun EmailPasswordComponent(
    loading: Boolean,
    email: MutableState<String>,
    password: MutableState<String>,
) {
    EmailPasswordField(
        isEnabled = !loading,
        email = email,
        password = password,
    )

}