package com.brickmate.medifoodcompose.extention

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*



@SuppressLint("SimpleDateFormat")
val datOfWeekFormat = SimpleDateFormat("MMM", Locale.ENGLISH)

@SuppressLint("SimpleDateFormat")
val datOfMonth = SimpleDateFormat("dd")

fun Date.getDateOfWeek(): String {

    return datOfWeekFormat.format(this)

}
fun Date.getDateFormat(): String {

    return datOfMonth.format(this)
}

fun Date.addDate(numberOfDate : Int):Date{
    val c = Calendar.getInstance()
    c.time = this
    c.add(Calendar.DATE, numberOfDate)
    return c.time
}
