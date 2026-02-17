package se.curtrune.lucinda.database

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import se.curtrune.lucinda.data.Item

interface ItemDao {
    @Upsert
    suspend fun upsert(item: Item)
    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM item ORDER BY dateEpoch ASC")
    fun getItems(): Flow<List<Item>>

}