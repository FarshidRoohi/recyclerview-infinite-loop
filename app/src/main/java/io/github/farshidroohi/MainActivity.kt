package io.github.farshidroohi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.pow


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sampleWithRecyclerView()
    }

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

    private fun getFakeItems(): List<String> {
        return arrayListOf<String>().apply {
            repeat(5) { number ->
                add(number.toString())
            }
        }
    }
}