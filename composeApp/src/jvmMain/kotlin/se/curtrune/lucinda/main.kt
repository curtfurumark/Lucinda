package se.curtrune.lucinda

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import se.curtrune.lucinda.database.getDatabase

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Lucinda",
    ) {
        val dao = getDatabase().dao
        App(dao)
    }
}