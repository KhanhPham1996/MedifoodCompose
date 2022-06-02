package com.brickmate.medifoodcompose.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brickmate.medifoodcompose.screen.home.HomeScreenItem.*
import com.brickmate.medifoodcompose.ui.theme.MainBackGround
import com.brickmate.medifoodcompose.ui_component.bottom_navigation.BottomNavItem
import java.util.*

@Composable
fun HomeScreen(openDrawer: () -> Unit,selectedHomeScreenItem : HomeScreenItem) {
    val navController = rememberNavController()
    Surface(modifier = Modifier.background(MainBackGround)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MainBackGround)
                .padding(11.dp)
        ) {
            HomeNavigation(navController)
            when(selectedHomeScreenItem){
                Meal ->navigateToScreen(navController,Meal.screen_route)
                BloodSugar ->navigateToScreen(navController,BloodSugar.screen_route)
                else -> {}
            }
        }
    }
}



@Composable
fun HomeNavigation(navController: NavHostController){
    NavHost(navController, startDestination = HomeScreenItem.Meal.screen_route) {
        composable(Meal.screen_route) {
            MealScreen()
        }
        composable(BloodSugar.screen_route) {
            BloodSugarScreen()
        }

    }}


@Preview
@Composable
fun PreviewItemDate() {
    HomeScreen(openDrawer = {},HomeScreenItem.Meal)

}



fun navigateToScreen(navController : NavHostController,screenRoot :String){
    navController.popBackStack()
    navController.navigate(screenRoot)

}
