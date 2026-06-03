package se.curtrune.lucinda.composables.dialogs

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog as M3DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Instant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialog(
    onDismiss: () -> Unit, onConfirm: (LocalDate) -> Unit
) {
    val datePickerState = rememberDatePickerState()
    M3DatePickerDialog(
        onDismissRequest = onDismiss, confirmButton = {
            TextButton(onClick = {
                datePickerState.selectedDateMillis?.let {
                    val date = Instant.fromEpochMilliseconds(it)
                        .toLocalDateTime(TimeZone.currentSystemDefault()).date

                    onConfirm(date)
                }
            }) {
                Text("Ok")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Avbryt")
            }
        }) {
        DatePicker(state = datePickerState)
    }
}
