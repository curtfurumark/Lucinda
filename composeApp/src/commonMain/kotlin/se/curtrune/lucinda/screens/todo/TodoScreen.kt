package se.curtrune.lucinda.screens.todo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import se.curtrune.lucinda.data.Item
import se.curtrune.lucinda.database.ItemDao
import kotlin.time.Clock

@Composable
fun TodoScreen(dao: ItemDao){
    val items by dao.getItems().collectAsState(emptyList())
    var text by remember { mutableStateOf("") }
    var epoch = Clock.System.now().toEpochMilliseconds()
    val coroutineScope = rememberCoroutineScope()
    fun  insert(text: String) {
        coroutineScope.launch() {
            epoch = Clock.System.now().toEpochMilliseconds()
            dao.upsert(Item(heading = text))
        }
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                insert(text)
            }) {
                Text("Add")
            }
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(100.dp))
            Text(text = "todo screen, size ${items.size}")
            OutlinedTextField(value = text, onValueChange = { text = it })
            Button(onClick = {
                insert(text)
            }) {
                Text("Add")
            }
            items.forEach {
                ItemCard(it)
            }
        }
    }
}
@Composable
fun ItemCard(item: Item){
    Card(modifier = Modifier.fillMaxWidth()){
        Text(text = item.heading)
        Text(text = item.created.toString())
        Text(text = item.modified.toString())
    }
}