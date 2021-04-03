package com.example.recyclerviewtest20210402

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewtest20210402.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val adapter = MyDataAdapter()
        // Importante: El recyclerview debe tener configurado el layoutManager
        binding.dataList.adapter = adapter

        //viewModel.changeData()

        viewModel.myListOfData.observe(this, Observer {
            it?.let {
                adapter.data = it
            }
        })
    }
}