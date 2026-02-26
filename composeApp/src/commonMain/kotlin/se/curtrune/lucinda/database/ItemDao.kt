package se.curtrune.lucinda.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import se.curtrune.lucinda.Item

@Dao
interface ItemDao {
    @Query("SELECT * FROM item")
    fun getAll(): Flow<List<Item>>
    @Delete
    suspend fun delete(item: Item)
    @Upsert
    suspend fun upsert(item: Item)

}