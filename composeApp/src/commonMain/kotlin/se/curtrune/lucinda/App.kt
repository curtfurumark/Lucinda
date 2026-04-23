package se.curtrune.lucinda

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

import se.curtrune.lucinda.database.ItemDao
import se.curtrune.lucinda.screens.todo.TodoScreen
import se.curtrune.lucinda.screens.todo.TodoViewModel

@Composable
fun App(viewModel: TodoViewModel) {
    MaterialTheme {
        TodoScreen(viewModel)
    }
}