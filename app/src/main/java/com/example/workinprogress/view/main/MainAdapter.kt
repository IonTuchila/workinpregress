package com.example.workinprogress.view.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.workinprogress.data.model.Location
import com.example.workinprogress.databinding.LocationItemBinding

class MainAdapter (private  val onClickListener : (Location) -> Unit) : ListAdapter<Location, MainViewHolder>(LocationDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder.from(parent, onClickListener)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}


class MainViewHolder private constructor(val binding: LocationItemBinding, private val onClickListener: (Location) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Location) {
        binding.data = item
        binding.root.setOnClickListener { onClickListener(item) }
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup, onClickListener: (Location) -> Unit, ): MainViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = LocationItemBinding.inflate(layoutInflater, parent, false)
            return MainViewHolder(binding, onClickListener)
        }
    }
}

class LocationDiffCallback : DiffUtil.ItemCallback<Location>() {

    override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean {
        return oldItem.label == newItem.label
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
        return oldItem == newItem
    }
}
