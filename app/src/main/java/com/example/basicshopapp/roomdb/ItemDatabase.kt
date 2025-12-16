package com.example.basicshopapp.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.basicshopapp.model.Item

@Database(entities = [Item::class], version = 1)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}

//Item kolonların isimlendirildiği yer
// ItemDao interface'i sorguların ve bu sorgu fonksiyonlarının isimlendirildiği interface.
//Item Database ise veritabanının room ile oluşturuluğu abstract class