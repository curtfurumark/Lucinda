package se.curtrune.lucinda

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

import se.curtrune.lucinda.navigation.NavigationRoot
import se.curtrune.lucinda.navigation.Route

@Composable
fun App() {
    val navSerializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(Route.TodoNavKey::class)
        }
    }
    MaterialTheme {
        NavigationRoot(
            modifier = Modifier,
            backStack = rememberNavBackStack(
                configuration = SavedStateConfiguration {
                    serializersModule = navSerializersModule
                },
                elements = arrayOf(Route.TodoNavKey)
            )
        )
    }
}