package com.example.my_boat.data

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity(tableName = "boat")
data class Boat(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "boat_name") val name: String
)

@Dao
interface BoatDao {
    @Query("SELECT * FROM boat")
    fun getAll(): List<Boat>

    @Insert
    fun insert(boat: Boat)

    @Insert
    fun insertAll(vararg users: Boat)

    @Delete
    fun delete(user: Boat)
}