package se.curtrune.lucinda.features.notifications

import androidx.compose.ui.text.intl.Locale
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlin.jvm.JvmField


@kotlinx.serialization.Serializable
class Notification {
    enum class Type {
        PENDING, ALARM, NOTIFICATION
    }

    @JvmField
    var type: Type = Type.NOTIFICATION
    private var date: Long = 0
    private var time = 0
    @JvmField
    var title: String? = null
    @JvmField
    var content: String? = null

    fun getDate(): LocalDate {
        return LocalDate.fromEpochDays(date)
    }

    fun getTime(): LocalTime {
        return LocalTime.fromSecondOfDay(time)
    }

    fun setDate(date: LocalDate) {
        this.date = date.toEpochDays()
    }

    fun setDate(string: CharSequence) {
        date = LocalDate.parse(string).toEpochDays()
    }


    fun setTime(time: LocalTime) {
        this.time = time.toSecondOfDay()
    }

    fun setTime(string: CharSequence) {
        time = LocalTime.parse(string).toSecondOfDay()
    }


    override fun toString(): String {
        return "$type.toString(), ${getDate()}"
            //Converter.format(getTime())

    }

    companion object {
        var VERBOSE: Boolean = false
    }
}
