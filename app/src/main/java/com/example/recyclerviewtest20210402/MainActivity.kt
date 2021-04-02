package com.example.recyclerviewtest20210402

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list_data: List<MyData> = listOf(
            MyData(2, "Juan", "12345"),
            MyData(2, "Franks", "56789"),
            MyData(3, "Edison", "34567")
        )


    }
}