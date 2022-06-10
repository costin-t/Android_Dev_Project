package com.example.myapp7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Activities
        //Open a PhotoApp With a Button
        val secondActivityBtn = findViewById<Button>(R.id.secondActivityBtn)
        secondActivityBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        // Open a RecyclerView
        val btn_activity3 = findViewById<Button>(R.id.btn_activity3)
        btn_activity3.setOnClickListener {
            val intent = Intent(this, Activity3::class.java)
            startActivity(intent)
        }
        // Open navigation
        val btn_nav = findViewById<Button>(R.id.btn_nav)
        btn_nav.setOnClickListener {
            val intent = Intent(this, Navigation1::class.java)
            startActivity(intent)
        }

        //Sharesheed
        var openShareSheet = findViewById<Button>(R.id.showSharesSheet)
        openShareSheet.setOnClickListener{
        mySharesSheet()
            }


        // Open Object Animator activity
        val btnanimation = findViewById<Button>(R.id.btn_animation)
        btnanimation.setOnClickListener {
            val intent = Intent(this, Animation::class.java)
            startActivity(intent)
    }
            //open Video playback
        val btnplay = findViewById<Button>(R.id.btn_video)
        btnplay.setOnClickListener{
            val intent = Intent(this, VideoPlayback::class.java)
            startActivity(intent)
        }

    }
    //Sharesheed
    fun mySharesSheet() {
        var message = "Hello \n\n" +
                "This is a sharessheet\n" +
                "Thank you"
        var intent = Intent()
        intent.type = "text/plain"
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, message)
        startActivity(intent)
    }

}