package com.example.myapp7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Motion_Layout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_layout)

        ////navigate back to the main activity
           val actionBar = supportActionBar
           actionBar!!.title = "Motion Layout"
           actionBar.setDisplayHomeAsUpEnabled(true)



    }
}