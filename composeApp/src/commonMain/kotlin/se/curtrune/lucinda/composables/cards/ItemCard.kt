package se.curtrune.lucinda.composables.cards

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import se.curtrune.lucinda.data.Item
import se.curtrune.lucinda.util.DateTimeFormatter

@Composable
fun ItemCard(item: Item, onChanged: (Item) -> Unit) {
    var checked by remember { mutableStateOf(item.isDone) }
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(checked = checked, onCheckedChange = {
                checked = it
                item.isDone = it
                onChanged(item)


            })

            Text(text = item.heading)


        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = DateTimeFormatter.formatLocalDate(item.targetDate))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = DateTimeFormatter.format(item.targetTime))
        }

    }

}
