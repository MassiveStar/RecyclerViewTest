package com.example.recyclerviewtest20210402

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private val _myListOfData = MutableLiveData<List<MyData>>()

    init {
        _myListOfData.value = listOf(
            MyData(1, "Juan", "12345"),
            MyData(2, "Pedro", "23456"),
            MyData(1, "Juan", "12345"),
            MyData(2, "Pedro", "23456"),
            MyData(1, "Juan", "12345"),
            MyData(2, "Pedro", "23456"),
            MyData(1, "Juan", "12345"),
            MyData(2, "Pedro", "23456"),
            MyData(1, "Juan", "12345"),
            MyData(2, "Pedro", "23456"),
            MyData(3, "Marco", "34512")
        )
    }

    val myListOfData: LiveData<List<MyData>>
        get() = _myListOfData

    fun changeData(){
        _myListOfData.value = listOf(
            MyData(3, "Ramon", "12345"),
            MyData(1, "Juana", "23456"),
            MyData(2, "Marcela", "34512")
        )
    }

    override fun onCleared() {
        super.onCleared()
        // Dispose All your Subscriptions to avoid memory leaks
    }
}