package se.curtrune.lucinda.screens.todo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import se.curtrune.lucinda.data.Item

@Composable
fun TodoScreen(viewModel: TodoViewModel) {
    val state by viewModel.state.collectAsState()
    var showDialog by remember { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                showDialog = true
            }) {
                Text("Add")
            }
        }) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(100.dp))

            state.items.forEach {
                ItemCard(it)
            }
        }
    }
    if (showDialog) {
        InsertItemDialog(
            onCancel = { showDialog = false },
            onConfirm = {
                viewModel.onEvent(TodoEvent.InsertItem(it))
                showDialog = false
            })
    }
}

@Composable
fun ItemCard(item: Item) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Text(text = item.heading)
        Text(text = item.created.toString())
        Text(text = item.modified.toString())
    }
}
