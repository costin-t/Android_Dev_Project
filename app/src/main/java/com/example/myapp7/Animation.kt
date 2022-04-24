package com.example.myapp7

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageView

class Animation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animation)
        //Object Animator
        val animateButton = findViewById<Button>(R.id.animateButton)
            //Miscarea in jos
        val redView = findViewById<View>(R.id.redView)
        animateButton.setOnClickListener {
            val tY: ValueAnimator = ObjectAnimator.ofFloat(
                redView,
                View.TRANSLATION_Y,
                redView.translationY,
                redView.translationY + 100f
            )

            tY.duration = 500
            tY.interpolator = LinearInterpolator()
            tY.start()
        }
        //Miscarea in dreapta
        val btn_up = findViewById<Button>(R.id.btn_dre)
        btn_up.setOnClickListener{
            val tY: ValueAnimator = ObjectAnimator.ofFloat(
                redView,
                View.TRANSLATION_X,
                redView.translationX,
                redView.translationX + 100f
            )
            tY.duration = 500
            tY.interpolator = LinearInterpolator()
            tY.start()
        }


        //navigate back to the main activity
        val actionBar = supportActionBar
        actionBar!!.title = "Object Animator"
        actionBar.setDisplayHomeAsUpEnabled(true)

        //Open the MotionLayout
        val btn_motionLayout = findViewById<Button>(R.id.btn_motionLayout)
        btn_motionLayout.setOnClickListener {
            val intent = Intent(this, Motion_Layout::class.java)
            startActivity(intent)

        }
    }
}