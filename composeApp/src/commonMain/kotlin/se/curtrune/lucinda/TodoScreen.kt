package se.curtrune.lucinda

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import se.curtrune.lucinda.database.ItemDao

@Composable
fun TodoScreen(dao: ItemDao){
    val items by dao.getItems().collectAsState(emptyList())


    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "todo screen, size ${items.size}")

    }

}