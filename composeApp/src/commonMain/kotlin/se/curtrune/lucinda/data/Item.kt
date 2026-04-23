package se.curtrune.lucinda.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import se.curtrune.lucinda.features.notifications.Notification
import kotlin.time.Clock

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(defaultValue = "0")
    var parentId: Long = 0,
    @ColumnInfo(defaultValue = "")
    val heading: String = "",
    @ColumnInfo(defaultValue = "")
    var comment: String = "",
    @ColumnInfo(defaultValue = "")
    var tags: String = "",
    @ColumnInfo(defaultValue = "")
    var category: String = "",
    @ColumnInfo(defaultValue = "0")
    val created: LocalDateTime = rightNow(),
    @ColumnInfo(defaultValue = "0")
    val modified: LocalDateTime = rightNow(),
    @ColumnInfo(defaultValue = "-1")
    val targetTime: LocalTime = rightNow().time,
    @ColumnInfo(defaultValue = "-1")
    val targetDate: LocalDate = rightNow().date,
    @ColumnInfo(defaultValue = "false")
    var isCalendar: Boolean = false,
    @ColumnInfo(defaultValue = "false")
    var isAppointment: Boolean = false,
    @ColumnInfo(defaultValue = "false")
    var isTemplate: Boolean = false,
    @ColumnInfo(defaultValue = "false")
    var isDone: Boolean = false,
    @ColumnInfo(defaultValue = "0")
    var duration: Long = 0,
    @ColumnInfo(defaultValue = "0")
    var energy: Int = 0,
    @ColumnInfo(defaultValue = "0")
    var mood: Int = 0,
    @ColumnInfo(defaultValue = "0")
    var stress: Int = 0,
    @ColumnInfo(defaultValue = "0")
    var anxiety: Int = 0,
    @ColumnInfo(defaultValue = "0")
    var priority: Int = 0,
    var notification: Notification? = null
)


fun rightNow(): LocalDateTime {
    return Clock.System.now().toLocalDateTime(timeZone = TimeZone.UTC)
}

