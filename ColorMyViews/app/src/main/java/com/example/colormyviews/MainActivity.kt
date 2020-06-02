package com.example.colormyviews

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.example.colormyviews.R.id.box_four
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    val images: List<Int> = listOf(
        R.drawable.image1_foreground,
        R.drawable.image2_foreground,
        R.drawable.image3_foreground,
        R.drawable.image4_foreground,
        R.drawable.image5_foreground
    )

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

        val clickableViews: List<View> = listOf(
            boxOne, boxTwo, boxThree, boxFour, boxFive, rootConstraintLayout
        )

        for (view in clickableViews) {
            view.setOnClickListener {
                val viewColor: Int? = if(it.background !== null) (it.background as ColorDrawable).color else null

                when(viewColor) {
                    -1 -> makeColored(it)
                    else -> removeColor(it)
                }


//                addImage(it)
            }
        }
    }

    private fun makeColored(view: View) = when(view.id) {
        // Boxes using Color class for the background
        R.id.box_one -> view.setBackgroundColor(Color.DKGRAY)
        R.id.box_two -> view.setBackgroundColor(Color.GRAY)
        R.id.box_three -> view.setBackgroundColor(Color.BLUE)
        box_four -> view.setBackgroundColor(Color.MAGENTA)
        R.id.box_five -> view.setBackgroundColor(Color.BLUE)
        else -> view.setBackgroundColor(Color.LTGRAY)
    }

    private fun removeColor(view: View) = view.setBackgroundColor(Color.WHITE)

    private fun addImage(view: View) { view.setBackgroundResource(getRandomImage())}

    private fun getRandomImage() = images[Random.nextInt(4)]
}
