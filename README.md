## Infinite Scroll loop with RecyclerView


RecyclerView Adapter:

```Kotlin
class RecyclerViewAdapter(private val items: List<String>) : RecyclerView.Adapter<RecyclerViewAdapter.RVViewHolder>() {

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
```
Usage:
```Kotlin

  private fun sampleWithRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val items = getFakeItems()
        val adapter = RecyclerViewAdapter(items)
        recyclerView.adapter = adapter

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        val position = items.size.toDouble().pow(5).toInt()
        recyclerView.scrollToPosition(position)
    }
```



https://github.com/FarshidRoohi/recyclerview-infinite-loop/assets/20150945/bc76e24a-4447-4284-8c6b-fed58a78d84c

