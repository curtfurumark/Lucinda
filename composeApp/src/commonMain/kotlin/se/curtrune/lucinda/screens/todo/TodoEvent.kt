package se.curtrune.lucinda.screens.todo

import se.curtrune.lucinda.data.Item

sealed interface TodoEvent {
    data class InsertItem(val item: Item): TodoEvent
    data class UpdateItem(val item: Item): TodoEvent
}