package se.curtrune.lucinda.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

fun getDatabase(context: Context): ItemDatabase {
    val dbFile = context.getDatabasePath("items.db").absolutePath
    return Room.databaseBuilder<ItemDatabase>(
        context.applicationContext,
        name = dbFile,
    ).setDriver(BundledSQLiteDriver()).build()

}