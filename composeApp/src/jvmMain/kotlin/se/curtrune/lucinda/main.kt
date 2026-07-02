package se.curtrune.lucinda

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import se.curtrune.lucinda.database.ItemDatabase
import se.curtrune.lucinda.database.getDatabase
import se.curtrune.lucinda.screens.todo.TodoViewModel

fun main() = application {
    ItemDatabase.INSTANCE = getDatabase()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Lucinda",
    ) {

        App()
    }
}