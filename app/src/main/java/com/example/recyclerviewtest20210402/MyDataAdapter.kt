package com.example.recyclerviewtest20210402

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyDataAdapter : RecyclerView.Adapter<MyDataAdapter.ViewHolder>() {

    var data = listOf<MyData>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDataAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyDataAdapter.ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameText: TextView = itemView.findViewById(R.id.name_text)
        val dniText: TextView = itemView.findViewById(R.id.dni_text)
        val sampleImage: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(item: MyData) {
            nameText.text = item.name
            dniText.text = item.dni
            sampleImage.setImageResource(
                when (item.image) {
                    1 -> R.drawable.andrea_1
                    2 -> R.drawable.betsy_2
                    else -> R.drawable.carlos_3
                }
            )
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.list_item_main_activity, parent, false)

                return ViewHolder(view)
            }
        }
    }

}