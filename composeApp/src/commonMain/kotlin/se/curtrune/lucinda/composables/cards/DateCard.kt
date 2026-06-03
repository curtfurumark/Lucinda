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
import kotlinx.datetime.LocalDate
import se.curtrune.lucinda.composables.dialogs.DatePickerDialog
import se.curtrune.lucinda.data.Item

@Composable
fun DateCard(item: Item, onDateChanged: (LocalDate) -> Unit) {
    var showDateDialog by remember { mutableStateOf(false) }
    Card {
        Text(
            text = item.targetDate.toString(),
            modifier = Modifier.clickable(onClick = { showDateDialog = true })
        )

    }
    if (showDateDialog) {
        DatePickerDialog(
            onDismiss = { showDateDialog = false },
            onConfirm = { onDateChanged(it); showDateDialog = false })
    }
}
