package se.curtrune.lucinda.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import se.curtrune.lucinda.data.Item

@Database(
    entities = [Item::class],
    version = 4,
    autoMigrations = [
        AutoMigration(
            from = 1, to = 4,
            spec = ItemAutoMigrationSpec::class
        )
    ]
)
@TypeConverters(RoomConverters::class)
abstract class ItemDatabase : RoomDatabase() {
    abstract val dao: ItemDao

    companion object {
        lateinit var INSTANCE: ItemDatabase
        fun getDatabase(): ItemDatabase {
            return INSTANCE
        }
    }
}