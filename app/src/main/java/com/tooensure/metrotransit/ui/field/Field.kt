package com.tooensure.metrotransit.ui.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Field(
    modifier: Modifier,
    state: MutableState<String> = rememberSaveable() { mutableStateOf("") },
    label: String = "",
    placeholderText: String = "Enter something",
    isEnabled: Boolean = true,
    isSingleLine: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onAction: KeyboardActions,
    visual: MutableState<Boolean> = remember {
        mutableStateOf(true)
    },
) {
    val visualTransformation = if (visual.value) VisualTransformation.None else PasswordVisualTransformation()

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = state.value,
        onValueChange = {x -> state.value = x },
        enabled = isEnabled,
        label = { Text(modifier = modifier,text = label) },
        placeholder = { Text(color = Color.Black,text = placeholderText) },
        singleLine = isSingleLine,
        textStyle = TextStyle(
            fontStyle = FontStyle(18),
            color = MaterialTheme.colorScheme.onBackground
        ),
        keyboardOptions = keyboardOptions,
        keyboardActions = onAction,
        visualTransformation = visualTransformation,
        trailingIcon = {
            Visual(visual = visual)
        }

    )
}

@Composable
fun Visual(visual: MutableState<Boolean>) {
    val visible = visual.value
    IconButton(onClick = { visual.value = !visible }) {
        Icons.Default.Close
    }
}


