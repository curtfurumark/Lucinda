package se.curtrune.lucinda.util

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

object DateTimeFormatter {
    fun format(time: LocalTime): String {
        val hour = time.hour.toString().padStart(2, '0')
        val minute = time.minute.toString().padStart(2, '0')
        return "$hour:$minute"
    }
    fun formatLocalDate(date: LocalDate): String {
     return date.toString()
    }
    }

