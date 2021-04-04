package com.example.recyclerviewtest20210402

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtest20210402.databinding.ListItemMainActivityBinding

class MyDataAdapter : ListAdapter<MyData, MyDataAdapter.ViewHolder>(MyDataDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDataAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyDataAdapter.ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(val binding: ListItemMainActivityBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MyData) {
            binding.nameText.text = item.name
            binding.dniText.text = item.dni
            binding.imageView.setImageResource(
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
                val binding =
                    ListItemMainActivityBinding.inflate(layoutInflater,parent,false)

                return ViewHolder(binding)
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