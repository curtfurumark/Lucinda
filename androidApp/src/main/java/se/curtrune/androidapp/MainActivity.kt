package se.curtrune.androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import se.curtrune.lucinda.App
import se.curtrune.lucinda.database.getDatabase

//import se.curtrune.lucinda.database.getDatabase

//import se.curtrune.lucinda.database.getDatabase

class MainActivity : ComponentActivity() {
    //private var platform: Unit = TODO("initialize me")

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            //Text(text = "hello android")
            val db = getDatabase(applicationContext)
            val dao = db.dao
            App(dao)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    //App()
}