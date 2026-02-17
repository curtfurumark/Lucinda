package se.curtrune.lucinda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import se.curtrune.lucinda.database.getDatabase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val dao = getDatabase(applicationContext).dao
            App(dao)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}