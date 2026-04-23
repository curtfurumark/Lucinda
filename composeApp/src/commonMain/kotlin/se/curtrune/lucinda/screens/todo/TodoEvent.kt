package se.curtrune.lucinda.screens.todo

import se.curtrune.lucinda.data.Item

sealed interface TodoEvent {
    class InsertItem(val item: Item): TodoEvent
}