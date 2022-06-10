package com.example.myapp7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.SearchView
import androidx.core.view.forEach
import java.util.*

class Activity3 : AppCompatActivity() {

    private lateinit var recyclearView : RecyclerView
    private lateinit var all_records : ArrayList<String>
    private lateinit var search_records : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
        //RecycleView
        //navigate back to the main activity
        val actionBar = supportActionBar
        actionBar!!.title="Recyclerview"
        actionBar.setDisplayHomeAsUpEnabled(true)

        //
        recyclearView  = findViewById(R.id.recyclerView)
        //set layout of our recyclerview as linear
        recyclearView.layoutManager = LinearLayoutManager(this)
        recyclearView.setHasFixedSize(true)

         all_records = fetchData()
         search_records = fetchData()

        showuseritems()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item,menu)
        val item = menu?.findItem(R.id.search_text)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                search_records.clear()
                val searchText = newText!!.lowercase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    val items = fetchData()
                    items.forEach{
                        if(it.toLowerCase(Locale.getDefault()).contains(searchText)){
                            search_records.add(it)
                        }
                    }

                    recyclearView.adapter!!.notifyDataSetChanged()

                }else{
                    search_records.clear()
                    search_records.addAll(all_records)
                    recyclearView.adapter!!.notifyDataSetChanged()
                }


                return false
            }

        })
        return super.onCreateOptionsMenu(menu)
    }


    // we will fetch data using
    fun fetchData() : ArrayList<String> {
        val list = ArrayList<String>()

        for(i in 0 until 20) {
            val insertnr = i*120
            list.add("item $insertnr")
        }

        /*
        list.add("Nature, in the broadest sense, is the physical world or universe")
        list.add(""Nature" can refer to the phenomena of the physical world, and also to life in general")
        list.add("The study of nature is a large, if not the only, part of science")
        list.add("Although humans are part of nature, human activity is often understood as a separate category from other natural phenomena")
        list.add("The word nature is borrowed from the Old French nature and is derived from the Latin word natura, or "essential qualities, innate disposition", and in ancient times, literally meant "birth".")
        */
        return list
    }

    private fun showuseritems() {

        val items = fetchData()

        search_records.addAll(items )

        recyclearView.adapter = RVAdaptor(search_records)

    }

}