package se.curtrune.lucinda.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import java.io.File

fun getDatabase(): ItemDatabase {
    val dbFile = File(System.getProperty("java.io.tmpdir"), "my_room.db")
    return Room.databaseBuilder<ItemDatabase>(
            name = dbFile.absolutePath,
            //factory = {ItemDatabase::class.instantiateImpl()},
        )
        .setDriver(BundledSQLiteDriver())
        .build()
}