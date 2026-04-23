package se.curtrune.lucinda.screens.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import se.curtrune.lucinda.data.Item
import se.curtrune.lucinda.database.ItemDao
import kotlin.time.Clock

class TodoViewModel(private val dao: ItemDao) : ViewModel() {
    private val _state = MutableStateFlow(TodoState())
    val state = _state.asStateFlow()

    init {
        dao.getItems().onEach { items ->
            _state.update {
                it.copy(items = items)

            }

        }
            .launchIn(viewModelScope)
    }

    fun onEvent(event: TodoEvent){
        when(event){
            is TodoEvent.InsertItem -> insert(event.item)
        }
    }
    fun insert(item: Item) {
        viewModelScope.launch {
            dao.upsert(item)
        }
    }
}