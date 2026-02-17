package se.curtrune.lucinda.database

import androidx.room.Database
import androidx.room.RoomDatabase
import se.curtrune.lucinda.data.Item

@Database(
    entities = [Item::class],
    version = 1
)
abstract class ItemDatabase: RoomDatabase() {
    abstract val dao: ItemDao

}