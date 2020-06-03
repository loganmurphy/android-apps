package com.example.colormyviews

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.colormyviews.R.id.box_four
import kotlin.random.Random


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
        val boxFour = findViewById<TextView>(box_four)
        val boxFive = findViewById<TextView>(R.id.box_five)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val redButton = findViewById<Button>(R.id.red_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)
        val greenButton = findViewById<Button>(R.id.green_button)

        val clickableViews: List<View> = listOf(
            boxOne, boxTwo, boxThree, boxFour, boxFive, rootConstraintLayout,
            redButton, yellowButton, greenButton
        )

        for (view in clickableViews) {
            view.setOnClickListener {
                val isButton = it::class.qualifiedName.toString().contains("Button", false)

                var viewColor: Int?
                if(isButton) {
                    viewColor = Random.nextInt(5)
                    makeButtonsColored(it, viewColor)
                } else {
                   viewColor = if(it.background !== null) (it.background as ColorDrawable).color else null
                    when(viewColor) {
                        -1 -> makeColored(it)
                        else -> removeColor(it)
                    }
                }
            }
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

    private fun makeButtonsColored(view: View, id: Int) = when(id) {
        1 -> view.setBackgroundResource(R.color.my_red)
        2 -> view.setBackgroundResource(R.color.my_green)
        3 -> view.setBackgroundResource(R.color.my_yellow)
        else -> view.setBackgroundResource(R.color.colorPrimary)
    }

    private fun removeColor(view: View) = view.setBackgroundColor(Color.WHITE)
}
