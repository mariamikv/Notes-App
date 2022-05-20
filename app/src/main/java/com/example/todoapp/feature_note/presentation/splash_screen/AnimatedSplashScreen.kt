package com.example.todoapp.feature_note.presentation.splash_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Note
import androidx.compose.material.icons.filled.NoteAlt
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.todoapp.R

@Composable
fun AnimatedSplashScreen(alpha: Float){
    Box(
        modifier = Modifier
            .background(
                if(isSystemInDarkTheme()){
                    Color.Black
                }else Color.LightGray
            )
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Icon(
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha),
            imageVector = Icons.Default.NoteAlt,
            contentDescription = stringResource(R.string.splash_screen_icon),
            tint = Color.White
        )
    }
}