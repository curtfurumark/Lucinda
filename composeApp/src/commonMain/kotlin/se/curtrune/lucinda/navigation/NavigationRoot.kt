package se.curtrune.lucinda.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.ui.NavDisplay
import kotlinx.serialization.Serializable
import se.curtrune.lucinda.database.ItemDatabase
import se.curtrune.lucinda.screens.day.DayScreen
import se.curtrune.lucinda.screens.index.IndexScreen
import se.curtrune.lucinda.screens.month.MonthScreen
import se.curtrune.lucinda.screens.todo.TodoScreen
import se.curtrune.lucinda.screens.todo.TodoViewModel
import se.curtrune.lucinda.screens.week.WeekScreen

sealed interface Route :
    NavKey {
    @Serializable
    data object TodoNavKey : Route
    @Serializable
    data object IndexNavKey : Route
    @Serializable
    data object DayNavKey : Route
    @Serializable
    data object WeekNavKey : Route
    @Serializable
    data object MonthNavKey : Route
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

            is Route.IndexNavKey -> NavEntry(navKey) {
                IndexScreen(navigate = { backStack.add(it) })
            }

            is Route.DayNavKey -> NavEntry(navKey) {
                DayScreen()

            }

            is Route.WeekNavKey -> NavEntry(navKey) {
                WeekScreen()
            }

            is Route.MonthNavKey -> NavEntry(navKey) {
                MonthScreen()
            }

            else -> error("Unknown navKey: $navKey")
        }

    })

}


