package io.github.farshidroohi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.farshidroohi.databinding.RvItemBinding
import kotlin.math.pow

class RecyclerViewAdapter(private val items: List<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter.RVViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = RvItemBinding.inflate(layoutInflater, parent, false)
        return RVViewHolder(view)
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        val realPosition = position % items.size
        val item = items[realPosition]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size.toDouble().pow(10).toInt()
    }

    class RVViewHolder(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            val page = itemView.resources.getString(R.string.page)
            binding.txtTitle.text = String.format(page, item)
        }
    }
}