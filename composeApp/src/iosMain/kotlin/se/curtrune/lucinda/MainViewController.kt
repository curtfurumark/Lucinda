package se.curtrune.lucinda

import androidx.compose.ui.window.ComposeUIViewController
import se.curtrune.lucinda.database.ItemDatabase
import se.curtrune.lucinda.database.getDatabase
import se.curtrune.lucinda.screens.todo.TodoViewModel

fun MainViewController() = ComposeUIViewController {
    val db = getDatabase()
    ItemDatabase.INSTANCE = db
    val dao = db.dao
    App(TodoViewModel(dao))
}