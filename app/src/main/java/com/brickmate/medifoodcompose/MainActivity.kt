package com.brickmate.medifoodcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.brickmate.medifoodcompose.ui.theme.MainBlue
import com.brickmate.medifoodcompose.ui.theme.MedifoodComposeTheme
import com.brickmate.medifoodcompose.ui_component.NavDrawer
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedifoodComposeTheme {
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = MaterialTheme.colors.isLight

                SideEffect {
                    // Update all of the system bar colors to be transparent, and use
                    // dark icons if we're in light theme
                    systemUiController.setSystemBarsColor(
                        color = MainBlue,

                    )

                    // setStatusBarsColor() and setNavigationBarColor() also exist
                }
                MainApp()
            }
        }
    }
}


@Preview
@Composable
fun MainApp(modifier: java.lang.reflect.Modifier = java.lang.reflect.Modifier()){
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Surface() {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopBar(title = "Ho",buttonIcon = Icons.Default.Menu, onButtonClicked = {
                    coroutineScope.launch {
                        Log.d("Henry", "onCreate: ")
                        scaffoldState.drawerState.open()
                    }
                })
            },
            drawerContent = { NavDrawer()},
            content = {}
        )
    }
}

