package com.example.lab3.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab3.entity.ItemModel
import com.example.lab3.entity.SliderModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class MainViewModel : ViewModel() {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    private val _banner = MutableLiveData<List<SliderModel>>()
    private val _popular = MutableLiveData<MutableList<ItemModel>>()

    val popular: LiveData<MutableList<ItemModel>> = _popular
    val banners: LiveData<List<SliderModel>> get() = _banner

    fun loadBanners() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val ref = firebaseDatabase.getReference("Banner")
                val snapshot = ref.get().await()
                val lists = mutableListOf<SliderModel>()
                for (childSnapshot in snapshot.children) {
                    val list = childSnapshot.getValue<SliderModel>()
                    if (list != null) {
                        lists.add(list)
                    }
                }
                _banner.postValue(lists)
            } catch (e: Exception) {
                println("Database error: ${e.message}")
            }
        }
    }

    fun loadBrand() {
        val ref = firebaseDatabase.getReference("Items")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<ItemModel>()
                for (childSnapshot in snapshot.children) {
                    val map = childSnapshot.value as? Map<String, Any> // Получаем данные как карту
                    if (map != null) {
                        val name = map["name"] as? String ?: ""
                        val description = map["description"] as? String ?: ""
                        val picUrl = map["picUrl"] as? ArrayList<String> ?: ArrayList()
                        val size = map["size"] as? ArrayList<String> ?: ArrayList()
                        val price = (map["price"] as? Number)?.toDouble() ?: 0.0
                        val rating = (map["rating"] as? Number)?.toDouble() ?: 0.0
                        val numberInCart = (map["numberInCart"] as? Number)?.toInt() ?: 0

                        val item = ItemModel(name, description, picUrl, size, price, rating, numberInCart)
                        lists.add(item)
                    }
                }
                _popular.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                // Обработка ошибок
                println("Database error: ${error.message}")
            }
        })
    }
}
