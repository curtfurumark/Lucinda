package se.curtrune.lucinda.composables.dialogs

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerDialog(
    onDismiss: () -> Unit,
    onConfirm: (LocalTime) -> Unit
) {
    val currentTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.hour,
        initialMinute = currentTime.minute,
        is24Hour = true,
    )
    AlertDialog(
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text("Avbryt")
            }
        },
        confirmButton = {
            TextButton(onClick = {
                onConfirm(
                    LocalTime(
                        timePickerState.hour,
                        timePickerState.minute
                    )
                )
            }) {
                Text("Ok")
            }
        },
        text = { TimePicker(state = timePickerState) }
    )
}
