package com.mj.rtslabs

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var listView1: ListView
    lateinit var listView2: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // use arrayadapter and define an array
        val arrayAdapter: ArrayAdapter<*>
        var inventory = mutableListOf("Shoes", "Pants", "Shirt")
        val arrayAdapter2: ArrayAdapter<*>
        var cart = mutableListOf<String>("Hat")

        listView1 = findViewById<ListView>(R.id.inventory_listview)
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, inventory
        )
        listView1.adapter = arrayAdapter

        listView2 = findViewById<ListView>(R.id.cart_listview)
        arrayAdapter2 = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, cart
        )
        listView2.adapter = arrayAdapter2

        listView1.setOnItemClickListener { _, _, index, _ ->

            val gg=inventory.removeAt(index)
            gg

            arrayAdapter.notifyDataSetChanged()

            cart.add(gg)
            arrayAdapter2.notifyDataSetChanged()

        }
        listView2.setOnItemClickListener { _, _, index, _ ->
            val gg=cart.removeAt(index)

            arrayAdapter.notifyDataSetChanged()

            inventory.add(gg)
            arrayAdapter2.notifyDataSetChanged()

        }
    }
}