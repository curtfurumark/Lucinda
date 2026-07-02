package se.curtrune.lucinda.screens.todo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import se.curtrune.lucinda.composables.cards.DateCard
import se.curtrune.lucinda.composables.cards.TimeCard
import se.curtrune.lucinda.data.Item

@Composable
fun InsertItemDialog(onCancel: () -> Unit, onConfirm: (Item) -> Unit) {
    var text by remember { mutableStateOf("") }
    val item by remember { mutableStateOf(Item()) }
    Dialog(onDismissRequest = { onCancel() }) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = CardDefaults.shape
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text("Add Item")
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Heading") },
                    modifier = Modifier.fillMaxWidth()
                )
                Row(modifier = Modifier.fillMaxWidth()) {
                    TimeCard(
                        item = item,
                        onTimeChanged = { item.targetTime = it })
                    Spacer(modifier = Modifier.width(8.dp))
                    DateCard(
                        item = item,
                        onDateChanged = { item.targetDate = it })
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(onClick = { onCancel() }) {
                        Text("Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = {
                        onConfirm(Item(heading = text))
                        text = ""
                    }) {
                        Text("Add")
                    }
                }
            }
        }
    }
}
