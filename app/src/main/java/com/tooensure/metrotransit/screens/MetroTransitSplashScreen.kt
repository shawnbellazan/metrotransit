package com.tooensure.metrotransit.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.tooensure.metrotransit.R
import com.tooensure.metrotransit.components.MetroTransitLogoIcon
import com.tooensure.metrotransit.components.MetroTransitLogoText
import com.tooensure.metrotransit.navigation.MetroTransitScreens
import kotlinx.coroutines.delay

@Composable
fun MetroTransitSplashScreen(navController: NavController)
{

    Surface(modifier = Modifier
        .padding(10.dp)
        .fillMaxSize()) {
       MetroTansitLogo(navController)
    }
}

@Composable
fun MetroTansitLogo(navController: NavController)
{
    val scale = remember {
        Animatable(.7f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f).getInterpolation(it)
                })
        )
        delay(2000L)
        if (FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty()) {
            navController.navigate(MetroTransitScreens.SignInScreen.name)
        } else {
            navController.navigate(MetroTransitScreens.HomeScreen.name)
        }
    }
    val _infiniteTransition = rememberInfiniteTransition()
    val twinCircleAnimation by _infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Column(
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally) {
        MetroTransitLogoIcon(twinCircleAnimation, scale)
        Spacer(modifier = Modifier.height(10.dp))
        MetroTransitLogoText(scale)
    }
}


