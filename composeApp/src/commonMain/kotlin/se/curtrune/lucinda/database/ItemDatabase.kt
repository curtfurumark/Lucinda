package se.curtrune.lucinda.database

import androidx.room.Database
import androidx.room.RoomDatabase
import se.curtrune.lucinda.Item

@Database(entities = [Item::class], version = 1)
abstract class ItemDatabase: RoomDatabase() {
    abstract fun getDao(): ItemDao
}


