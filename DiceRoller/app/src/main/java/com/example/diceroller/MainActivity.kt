package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    /*
        storing result of findViewById to prevent expensive search operation
        every time button is clicked
        using lateinit keyword is preferable to assigning null
    */
    private lateinit var diceImage1: ImageView
    private lateinit var diceImage2: ImageView

    private val diceImages = listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3,
        R.drawable.dice_4,
        R.drawable.dice_5,
        R.drawable.dice_6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
    }

    private fun getRandomDiceImage(): Int = diceImages.random()

    private fun rollDice() {
        /*
            makeText takes a context object as the first argument, since AppCompatActivity
            inherits from Context, we can pass in this
        */
        val die1Image = getRandomDiceImage()
        val die2Image = getRandomDiceImage()

        diceImage1.setImageResource(die1Image)
        diceImage2.setImageResource(die2Image)
    }

}
