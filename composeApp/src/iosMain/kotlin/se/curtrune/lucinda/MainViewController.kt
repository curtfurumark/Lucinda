package se.curtrune.lucinda

import androidx.compose.ui.window.ComposeUIViewController
import se.curtrune.lucinda.database.getDatabase

fun MainViewController() = ComposeUIViewController {

    val dao = getDatabase().dao
    App(dao) }