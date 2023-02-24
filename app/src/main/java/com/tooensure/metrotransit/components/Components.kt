package com.tooensure.metrotransit.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.tooensure.metrotransit.R

val globalScale = Animatable(.7f)

@Composable
fun MetroTransitLogoText(scale: Animatable<Float, AnimationVector1D>) {
    Image(
        modifier = Modifier.scale(scale.value),
        painter = painterResource(
            id = R.drawable.mt_logo_text
        ),
        contentDescription = "logo text"
    )
}


@Composable
fun MetroTransitLogoIcon(
    twinCircleAnimation: Float,
    scale: Animatable<Float, AnimationVector1D>,
) {
    Box(modifier = Modifier.size(70.dp))
    {
        Image(
            modifier = Modifier
                .rotate(twinCircleAnimation)
                .shadow(5.dp, shape = CircleShape),
            painter = painterResource(
                id = R.drawable.mt_logo_bg
            ),
            contentDescription = "backdround"
        )
        Image(
            modifier = Modifier
                .size(40.dp)
                .align(Alignment.Center)
                .scale(scale = scale.value),
            painter = painterResource(
                id = R.drawable.mt_red_logo
            ),
            contentDescription = "backdround"
        )
    }
}
@Composable
fun NavButton(text: String, textBtn: String, onClick: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = text)
        TextButton(modifier = Modifier.padding(0.dp),onClick = onClick) {
            Text(text = textBtn)
        }
    }
}



@Composable
fun SubmitButton(
    textId: String,
    loading: Boolean,
    validInputs: Boolean,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        enabled = !loading && validInputs,
        shape = CircleShape,
        onClick = onClick) {
        if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
        else Text(text = textId, modifier = Modifier.padding(5.dp))
    }
}
