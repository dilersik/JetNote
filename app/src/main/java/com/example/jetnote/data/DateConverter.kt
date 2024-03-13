package com.example.jetnote.data

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun fromDateToTimeInMilli(date: Date) = date.time

    @TypeConverter
    fun fromTimeInMilliToDate(time: Long) = Date(time)
}