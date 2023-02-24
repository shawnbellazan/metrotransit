package com.tooensure.metrotransit.ui.field

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

const val trueBase : Boolean = true
const val empty : String = ""
@Composable
fun PasswordField(
    modifier: Modifier = Modifier,
    state: MutableState<String> = rememberSaveable() { mutableStateOf("") },
    label: String = "Password",
    visual: MutableState<Boolean>,
    isEnabled: Boolean = trueBase,
    isSingleLine: Boolean = trueBase,
    imeAction: ImeAction,
    onImeAction: KeyboardActions
) {
    Field(
        modifier = modifier,
        state = state,
        label = label,
        isEnabled = isEnabled,
        isSingleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        onAction = onImeAction,
        visual = visual
    )
}