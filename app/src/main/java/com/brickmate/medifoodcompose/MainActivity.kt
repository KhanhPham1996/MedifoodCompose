package com.brickmate.medifoodcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.brickmate.medifoodcompose.screen.AnalyticsScreen
import com.brickmate.medifoodcompose.screen.HomeScreen
import com.brickmate.medifoodcompose.screen.MapScreen
import com.brickmate.medifoodcompose.screen.ShoppingScreen
import com.brickmate.medifoodcompose.ui.theme.MainBlue
import com.brickmate.medifoodcompose.ui.theme.MedifoodComposeTheme
import com.brickmate.medifoodcompose.ui_component.bottom_navigation.AppBottomNavigation
import com.brickmate.medifoodcompose.ui_component.bottom_navigation.BottomNavItem
import com.brickmate.medifoodcompose.ui_component.drawer.NavDrawer
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
fun MainApp() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var currentRoute by remember{
        mutableStateOf<String?>(null)
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
                TopBar(buttonIcon = Icons.Default.Menu,navRoot = currentRoute, onButtonClicked = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                })
            },
        drawerContent = { NavDrawer() },
        bottomBar = { AppBottomNavigation(navController = navController, onPageChange = {
            currentRoute = it
        }) }
    ) {

        BottomNavigationGraph(navController = navController,it)
    }
}


@Composable
fun BottomNavigationGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen {}
        }
        composable(BottomNavItem.Analytics.screen_route) {
            AnalyticsScreen {}
        }
        composable(BottomNavItem.Map.screen_route) {
            MapScreen {}
        }
        composable(BottomNavItem.Shopping.screen_route) {
            ShoppingScreen {}
        }



    }
}

