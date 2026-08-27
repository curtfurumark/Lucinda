package se.curtrune.lucinda.screens.index

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import se.curtrune.lucinda.navigation.Route

@Composable
fun IndexScreen(navigate: (NavKey) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Todo", modifier = Modifier.clickable(onClick = {
            navigate(Route.TodoNavKey)
        }
        )
        )

        Text("Day", modifier = Modifier.clickable(onClick = {
            navigate(Route.DayNavKey)
        }
        )
        )

        Text("Week", modifier = Modifier.clickable(onClick = {
            navigate(Route.WeekNavKey)
        }
        )
        )

        Text("Month", modifier = Modifier.clickable(onClick = {
            navigate(Route.MonthNavKey)
        }
        )
        )

    }
}