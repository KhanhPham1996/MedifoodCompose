package com.brickmate.medifoodcompose.screen.home

sealed class HomeScreenItem( val title : String,val screen_route: String) {

    object Meal : HomeScreenItem("식사" ,"meal")
    object BloodSugar: HomeScreenItem( "혈당","blood_sugar")
    object BloodPressure: HomeScreenItem( "혈압","blood_pressure")
    object Exercise: HomeScreenItem( "운동","exercise")
    object Weight: HomeScreenItem( "몸무게","weight")
    object More: HomeScreenItem( "기타", "more")


    companion object {
        val listHomeScreenItem = listOf(Meal, BloodSugar, BloodPressure,Exercise,Weight,More)
    }

}
