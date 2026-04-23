package se.curtrune.lucinda.database

import androidx.room.migration.AutoMigrationSpec
import androidx.room.RenameColumn

@RenameColumn(
    tableName = "Item",
    fromColumnName = "title",
    toColumnName = "heading"
)
@RenameColumn(
    tableName = "Item",
    fromColumnName = "dateEpoch",
    toColumnName = "targetDate"
)

class ItemAutoMigrationSpec : AutoMigrationSpec
