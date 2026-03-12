package se.curtrune.lucinda.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import se.curtrune.lucinda.data.Item

@Database(
    entities = [Item::class],
    version = 3,
    autoMigrations = [
        AutoMigration(from = 2, to = 3)
    ]
)
@TypeConverters(RoomConverters::class)
abstract class ItemDatabase: RoomDatabase() {
    abstract val dao: ItemDao

}