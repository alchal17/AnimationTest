package com.example.animationtest

import android.os.Bundle
import android.sax.Element
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animationtest.ui.theme.AnimationTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPage()
                }
            }
        }
    }

    @Composable
    private fun MainPage() {
        var counter by remember { mutableStateOf(1) }
        Column(modifier = Modifier.clickable { counter++ }) {
            repeat(counter) {
                Element()
            }
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    private fun Element() {
        var visible by remember { mutableStateOf(false) }
        AnimatedVisibility(visible = visible, enter = scaleIn(), exit = scaleOut()) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.Green)
                    .clickable { visible = !visible }
            )
        }
        LaunchedEffect(Unit){
            visible = true
        }
    }
}