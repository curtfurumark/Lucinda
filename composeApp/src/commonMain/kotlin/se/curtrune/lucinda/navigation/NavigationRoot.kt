package se.curtrune.lucinda.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import kotlinx.serialization.Serializable
import se.curtrune.lucinda.database.ItemDatabase
import se.curtrune.lucinda.screens.todo.TodoScreen
import se.curtrune.lucinda.screens.todo.TodoViewModel

sealed interface Route : NavKey {
    @Serializable
    data object TodoNavKey : Route
}


@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier,
    backStack: NavBackStack<NavKey>
) {
    NavDisplay(backStack = backStack, modifier = modifier, entryProvider = { navKey ->
        when (navKey) {
            is Route.TodoNavKey -> NavEntry(navKey) {
                TodoScreen(viewModel = TodoViewModel(ItemDatabase.getDatabase().dao))
            }

            else -> error("Unknown navKey: $navKey")
        }

    })

}


