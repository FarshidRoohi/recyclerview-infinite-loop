package io.github.farshidroohi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.farshidroohi.databinding.RvItemBinding

class RecyclerViewAdapter(private val items: List<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter.RVViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        val view = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RVViewHolder(view)
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class RVViewHolder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.txtTitle.text = item
        }

    }
}