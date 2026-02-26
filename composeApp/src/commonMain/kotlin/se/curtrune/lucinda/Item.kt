package se.curtrune.lucinda

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(@PrimaryKey(autoGenerate = true)
                val id: Int,
                val heading: String,
                val dateEpoch: Long)
