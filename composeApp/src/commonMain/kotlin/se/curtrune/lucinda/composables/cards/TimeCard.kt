package se.curtrune.lucinda.composables.cards

import androidx.compose.foundation.clickable
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.datetime.LocalTime
import se.curtrune.lucinda.composables.dialogs.TimePickerDialog
import se.curtrune.lucinda.data.Item
import se.curtrune.lucinda.util.DateTimeFormatter

@Composable
fun TimeCard(item: Item, onTimeChanged: (LocalTime) -> Unit) {
    var showTimeDialog by remember { mutableStateOf(false) }
    Card {
        Text(
            text = DateTimeFormatter.format(item.targetTime),
            modifier = Modifier.clickable(onClick = { showTimeDialog = true })
        )

    }
    if (showTimeDialog) {
        TimePickerDialog(
            onDismiss = { showTimeDialog = false },
            onConfirm = { onTimeChanged(it); showTimeDialog = false })
    }
}
