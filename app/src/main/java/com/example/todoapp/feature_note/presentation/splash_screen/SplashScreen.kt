package com.example.todoapp.feature_note.presentation.splash_screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.example.todoapp.feature_note.presentation.utlis.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
){
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )
    
    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screen.NotesScreen.route)
    }
    AnimatedSplashScreen(alphaAnim.value)
}