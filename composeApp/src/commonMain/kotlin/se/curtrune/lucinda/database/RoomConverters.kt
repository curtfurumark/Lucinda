package se.curtrune.lucinda.database

import androidx.room.TypeConverter
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.json.Json
import se.curtrune.lucinda.features.notifications.Notification
import kotlin.time.Instant

class RoomConverters {
    @TypeConverter
    fun fromLocalDateTime(value: LocalDateTime): Long {
        return value.toInstant(TimeZone.UTC).toEpochMilliseconds()
    }

    @TypeConverter
    fun toLocalDateTime(value: Long): LocalDateTime {
        return Instant.fromEpochMilliseconds(value).toLocalDateTime(TimeZone.UTC)
    }

    @TypeConverter
    fun fromLocalDate(date: LocalDate): Long {
        return date.toEpochDays()
    }

    @TypeConverter
    fun toLocalDate(dateEpoch: Long): LocalDate {
        return LocalDate.fromEpochDays(epochDays = dateEpoch)
    }

    @TypeConverter
    fun fromLocalTime(time: LocalTime): Int {
        return time.toSecondOfDay()
    }

    @TypeConverter
    fun toLocalTime(secondOfDay: Int): LocalTime {
        return LocalTime.fromSecondOfDay(secondOfDay)
    }

    @TypeConverter
    fun toNotification(value: String): Notification {
        return Json.decodeFromString(value)
    }
    @TypeConverter
    fun fromNotification(value: Notification): String {
        return Json.encodeToString(value)
    }

}