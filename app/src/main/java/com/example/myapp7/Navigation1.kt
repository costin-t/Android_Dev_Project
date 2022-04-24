package com.example.myapp7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView

class Navigation1 : AppCompatActivity() {

    private lateinit var status_text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation1)

        //navigate back to the main activity
        val actionBar = supportActionBar
        actionBar!!.title = "Navigation"
        actionBar.setDisplayHomeAsUpEnabled(true)

        status_text = findViewById(R.id.status_text)

        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater:MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.profile -> {
                status_text.text = "Profile menu Clicked"
                true
            }
            R.id.settings -> {
                status_text.text = "Settings menu Clicked"
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

}
