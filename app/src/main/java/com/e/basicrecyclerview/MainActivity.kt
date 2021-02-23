package com.e.basicrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recView: RecyclerView
    private lateinit var recAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView = findViewById(R.id.recView)
        recAdapter = RecyclerAdapter(itemGenerator())
        recView.adapter = recAdapter
        recAdapter.notifyDataSetChanged()

        val layoutManager = LinearLayoutManager(applicationContext)
        recView.layoutManager = layoutManager
        layoutManager.orientation = LinearLayoutManager.VERTICAL
    }

    fun itemGenerator(): List<Item>{

        val items: MutableList<Item> = ArrayList()

        val i1 = Item(R.drawable.itemf, "First item", "First short desc", "First Full Desc")
        val i2 = Item(R.drawable.items, "Second item", "Second short desc", "Second full Desc")
        val i3 = Item(R.drawable.itemt, "Third item", "Third short desc", "Third full Desc")
        val i4 = Item(R.drawable.itemf, "Fourth item", "Fourth short desc", "Fourth full Desc")
        val i5 = Item(R.drawable.itemfir, "Fifth item", "Fifth short desc", "Fifth full Desc")
        val i6 = Item(R.drawable.itemsi, "Sixth item", "Sixth short desc", "Sixth full Desc")

        items.add(i1)
        items.add(i2)
        items.add(i3)
        items.add(i4)
        items.add(i5)
        items.add(i6)

        return items
    }
}