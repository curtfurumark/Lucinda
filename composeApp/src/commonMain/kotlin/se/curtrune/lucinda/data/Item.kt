package se.curtrune.lucinda.data

import androidx.compose.foundation.MutatePriority
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var parentId: Long = 0,
    val heading: String = "",
    var comment: String = "",
    var tags: String = "",
    var category: String = "",
    @ColumnInfo( defaultValue = "0")
    val created: LocalDateTime = rightNow(),
    @ColumnInfo( defaultValue = "0")
    val modified: LocalDateTime = rightNow(),
    @ColumnInfo( defaultValue = "-1")
    val targetTime: LocalTime = rightNow().time,
    @ColumnInfo( defaultValue = "-1")
    val targetDate: LocalDate = rightNow().date,
    val isCalendar: Boolean = false,
    val isAppointment: Boolean = false,
    var isTemplate: Boolean = false,
    var duration : Long = 0,
    var energy: Int = 0,
    var mood: Int = 0,
    var stress: Int = 0,
    var anxiety: Int = 0,
    var priority: Int = 0
)


fun rightNow(): LocalDateTime {
    return Clock.System.now().toLocalDateTime(timeZone = TimeZone.UTC)
}

