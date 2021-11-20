package com.example.roomdatabasepractice_mvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ProgrammingAdapter: ListAdapter<ProgrammingItem, ProgrammingAdapter.ProgrammingViewHolder>(DiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ProgrammingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ProgrammingViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.name)
        val initial = view.findViewById<TextView>(R.id.initial)

        fun bind(item: ProgrammingItem) {
            name.text = item.name
            initial.text = item.initial
        }
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<ProgrammingItem>() {
        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            return oldItem.Id == newItem.Id
        }

        override fun areContentsTheSame(
            oldItem: ProgrammingItem,
            newItem: ProgrammingItem
        ): Boolean {
            return oldItem == newItem
        }


    }
}