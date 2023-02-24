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

@Composable
fun EmailField(
    modifier: Modifier = Modifier,
    state: MutableState<String> = rememberSaveable() { mutableStateOf("") },
    label: String = "Email",
    placeholderText: String = "Email",
    isEnabled: Boolean = true,
    isSingleLine: Boolean = true,
    imeAction: ImeAction,
    onImeAction: KeyboardActions = KeyboardActions.Default
) {

    Field(
        modifier = modifier,
        state = state,
        label = label,
        placeholderText = placeholderText,
        isEnabled = isEnabled,
        isSingleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = imeAction
        ),
        onAction = onImeAction
    )
}