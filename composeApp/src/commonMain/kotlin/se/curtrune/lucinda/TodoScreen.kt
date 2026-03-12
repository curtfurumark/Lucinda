package se.curtrune.lucinda

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import se.curtrune.lucinda.database.ItemDao
import kotlin.time.Clock

@Composable
fun TodoScreen(dao: ItemDao){
    val items by dao.getItems().collectAsState(emptyList())
    var text by remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope();


    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "todo screen, size ${items.size}")
        OutlinedTextField(text, onValueChange = {text = it})
        Button(onClick = {

            coroutineScope.launch {
                    dao.upsert(Item(0, text, Clock.System.now().epochSeconds))
                }

        }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Add item")
        }

    }

    }

