package com.jonaswanke.calendar.utils

import java.util.*


const val WEEK_IN_DAYS = 7
val WEEK_DAYS = 0 until WEEK_IN_DAYS
const val DAY_IN_HOURS = 24
val DAY_HOURS = 0 until DAY_IN_HOURS
const val HOUR_IN_MINUTES = 60
const val MINUTE_IN_SECONDS = 60

internal const val HASHCODE_FACTOR = 31


internal val TODAY: GregorianCalendar = GregorianCalendar().apply {
    timeOfDay = 0
}

internal val TOMORROW: GregorianCalendar = (TODAY.clone() as GregorianCalendar).apply {
    add(Calendar.DAY_OF_WEEK, 1)
}

fun Long.toCalendar(): GregorianCalendar {
    return GregorianCalendar().apply { timeInMillis = this@toCalendar }
}

val Calendar.isToday: Boolean
    get() = TODAY.timeInMillis <= timeInMillis && timeInMillis < TOMORROW.timeInMillis
val Calendar.isFuture: Boolean
    get() = TODAY.timeInMillis < timeInMillis
