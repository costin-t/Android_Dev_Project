package com.example.myapp7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        //navigate back to the main activity
        val actionBar = supportActionBar
        actionBar!!.title="Recyclerview"
        actionBar.setDisplayHomeAsUpEnabled(true)

        //
        val recyclearView : RecyclerView = findViewById(R.id.recyclerView)
        //set layout of our recyclerview as linear
        recyclearView.layoutManager = LinearLayoutManager(this)
        //we need adaptor and viewHolder for RV

        val items = fetchData()
        //set adaptor
        val adaptor = RVAdaptor( items)
        recyclearView.adapter = adaptor

    }

    // we will fetch data using
    fun fetchData() : ArrayList<String> {
        val list = ArrayList<String>()
        for(i in 0 until 20) {
            list.add("item $i")
        }
        //val list : Array<String> = arrayOf("Item 9", "item 2", "item 3", "item 4", "item 5", "item 6", "item 7", "item 8","Item 9", "item 10", "item 11", "item 12", "item 13", "item 14", "item 15", "item 16")
        return list
    }

}