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
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

/**
 * Core composable for input field.
 * @return reusable composable.
 */
/**
 * # Tooensure Backpack input field
 *
 * Input fields allow users to enter text into a UI. </b>
 * They appear in forms and dialogs.
 * Email and Password fields are by default single lined unless defined different on construction.
 * their reduced emphasis helps
 * simplify the layout.
 *
 * ![Email and Password fields](url)
 *
 * See example usage:
 * @sample com.tooensure.travel.forms.EmailField
 * @sample com.tooensure.travel.forms.PasswordField
 *
 * If apart from email field, you also want to observe the Password field,
 * with IME composition use the InputField overload with the [ImeAction] and [KeyboardActions] parameter
 * instead.
 *
 * @param value the input text to be shown in the text field
 * @param onValueChange the callback that is triggered when the input service updates the text. An
 * updated text comes as a parameter of the callback
 * @param modifier the [Modifier] to be applied to this text field
 * @param enabled controls the enabled state of this text field. When `false`, this component will
 * not respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param readOnly controls the editable state of the text field. When `true`, the text field cannot
 * be modified. However, a user can focus it and copy text from it. Read-only text fields are
 * usually used to display pre-filled forms that a user cannot edit.
 * in different states. See [TextFieldDefaults.outlinedTextFieldColors].
 */

@Composable
fun InputField(
    label: String,
    input: MutableState<String>,
    onAction: KeyboardActions,
    onDone: (String) -> Unit = { a ->}
) {
    Field(
        modifier = Modifier,
        label = label,
        state = input,
        isSingleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        onAction = onAction)

}