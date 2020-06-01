package com.example.colormyviews

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val boxOne = findViewById<TextView>(R.id.box_one)
        val boxTwo = findViewById<TextView>(R.id.box_two)
        val boxThree = findViewById<TextView>(R.id.box_three)
        val boxFour = findViewById<TextView>(R.id.box_four)
        val boxFive = findViewById<TextView>(R.id.box_five)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val clickableViews: List<View> = listOf(
            boxOne, boxTwo, boxThree, boxFour, boxFive, rootConstraintLayout
        )

        for (view in clickableViews) {
            view.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) = when(view.id) {
        // Boxes using Color class for the background
        R.id.box_one -> view.setBackgroundColor(Color.DKGRAY)
        R.id.box_two -> view.setBackgroundColor(Color.GRAY)
        R.id.box_three -> view.setBackgroundColor(Color.BLUE)
        R.id.box_four -> view.setBackgroundColor(Color.MAGENTA)
        R.id.box_five -> view.setBackgroundColor(Color.BLUE)
        else -> view.setBackgroundColor(Color.LTGRAY)
    }
}
