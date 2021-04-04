package com.example.recyclerviewtest20210402

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MyDataAdapter : ListAdapter<MyData, MyDataAdapter.ViewHolder>(MyDataDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDataAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyDataAdapter.ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
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

class MyDataDiffCallback : DiffUtil.ItemCallback<MyData>(){
    override fun areItemsTheSame(oldItem: MyData, newItem: MyData): Boolean {
        return oldItem.dni == newItem.dni
    }

    override fun areContentsTheSame(oldItem: MyData, newItem: MyData): Boolean {
        return oldItem == newItem
    }


}