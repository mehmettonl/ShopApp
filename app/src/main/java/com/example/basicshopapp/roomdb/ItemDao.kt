package com.example.basicshopapp.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.basicshopapp.model.Item

//@dao bu interfacelerin DB işlemleri için kullanıldığı anlamına gelir.
@Dao
interface ItemDao {

    @Query("SELECT name , id FROM item")
    fun getItemWithyNameAndId(): List<Item>

    @Query("SELECT * FROM item WHERE id = :id")
    fun getItemById(id: Int) : Item?

    @Query("SELECT * FROM item")
    fun getAllItem(): List<Item>

    @Insert
    suspend fun insert(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Update
    suspend fun update(item : Item)


}