package com.brickmate.medifoodcompose.ui_component.bottom_navigation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.brickmate.medifoodcompose.R
import com.brickmate.medifoodcompose.ui.theme.MainBlue
import com.brickmate.medifoodcompose.ui.theme.MainGray

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object Home : BottomNavItem("포인트 식이요법", R.drawable.ic_dashboard,"home")
    object Analytics: BottomNavItem("보고서",R.drawable.ic_report,"analytics")
    object Map: BottomNavItem("당뇨 평가 우수 병원",R.drawable.ic_location,"map")
    object Shopping: BottomNavItem("당뇨 평가 우수 병원",R.drawable.ic_cart,"shopping")

    companion object {
        val listBottomNavItem = listOf(Home, Analytics,
            Map, Shopping)
    }

}

@Composable
fun AppBottomNavigation(navController: NavController,onPageChange: (String) -> Unit ){
    BottomNavigation(
        backgroundColor = (Color.White),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        BottomNavItem.listBottomNavItem.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = "") },
                label = { Text(text = item.title,
                    fontSize = 9.sp) },
                selectedContentColor = MainBlue,
                unselectedContentColor = MainGray,
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    onPageChange.invoke(item.title)
                }
            )
        }
    }
}

