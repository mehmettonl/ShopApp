package com.example.basicshopapp.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.basicshopapp.model.Item
import com.example.basicshopapp.roomdb.ItemDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//AndroidViewModel -> context kullanmak için bu context'te burada application
class ItemViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        getApplication(),
        ItemDatabase::class.java, "Items"
    ).build()

    private val itemDao = db.itemDao()


    val itemList = mutableStateOf<List<Item>>(listOf())
    //listOf() -> boş liste
    val selectedItem = mutableStateOf(Item("", "", "", ByteArray(1)))

    fun getItemList(){
        viewModelScope.launch(Dispatchers.IO){
            itemList.value = itemDao.getItemWithyNameAndId()
        }
    }

    fun getItem(id : Int){
        viewModelScope.launch(Dispatchers.IO){
            val item = itemDao.getItemById(id)
            item?.let {
                selectedItem.value = it
            }
        }
    }

    fun saveItem(item : Item){
        viewModelScope.launch(Dispatchers.IO){
           itemDao.insert(item)
        }
    }

    fun deleteItem(item : Item){
        viewModelScope.launch(Dispatchers.IO){
            itemDao.delete(item)
        }
    }

    fun updateItem(item : Item){
        viewModelScope.launch(Dispatchers.IO){
            itemDao.update(item)
        }
    }

}







