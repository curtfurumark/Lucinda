package se.curtrune.lucinda.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

fun getDatabase(): ItemDatabase {
    val dbFile = NSHomeDirectory() + "/database.db"
    return Room.databaseBuilder<ItemDatabase>(
        name = dbFile,
        factory = {ItemDatabase::class.instantiateImpl()}
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}
