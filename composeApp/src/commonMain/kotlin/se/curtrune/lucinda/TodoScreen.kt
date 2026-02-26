package se.curtrune.lucinda

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import se.curtrune.lucinda.database.ItemDao

@Composable
fun TodoScreen(dao: ItemDao){
    val items by dao.getItems().collectAsState(emptyList())


    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "todo screen, size ${items.size}")

    }

}