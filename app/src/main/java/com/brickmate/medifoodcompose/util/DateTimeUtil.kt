package com.brickmate.medifoodcompose.util

import com.brickmate.medifoodcompose.extention.getDateFormat
import com.brickmate.medifoodcompose.extention.getDateOfWeek
import java.util.*

object DateTimeUtil {
    fun getSevenDateOfWeek(date : Date): List<Date>{
        val cal = Calendar.getInstance()
        cal.time  = date
        cal.set(Calendar.DAY_OF_WEEK,cal.firstDayOfWeek)
        val firstDate = cal.time
        val listDate = mutableListOf<Date>()
        for(i in 1..7){
            cal.time = firstDate
            cal.add(Calendar.DATE,i)
            val addedDate = cal.time
            listDate.add(addedDate)

        }

        return listDate

    }
}