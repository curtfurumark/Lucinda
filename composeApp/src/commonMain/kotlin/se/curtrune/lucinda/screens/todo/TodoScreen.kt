package se.curtrune.lucinda.screens.todo

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.lazy.LazyColumn
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
import se.curtrune.lucinda.composables.cards.ItemCard


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

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
            items(state.items.size) {
                ItemCard(
                    item = state.items[it],
                    onChanged = { item ->
                        viewModel.onEvent(TodoEvent.UpdateItem(item))
                    })

                Spacer(modifier = Modifier.height(2.dp))

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

