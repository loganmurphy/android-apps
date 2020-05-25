package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val incrementButton: Button = findViewById(R.id.increment_button)
        incrementButton.setOnClickListener { countUp() }
    }

    private fun rollDice() {
        /*
            makeText takes a context object as the first argument, since AppCompatActivity
            inherits from Context, we can pass in this
        */
        val randomInt = (1..6).random()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()

        if(randomInt == 6) {
            Toast.makeText(this, "We have a winner!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        val parsedValue: Int? = resultText.text.toString().toIntOrNull()
        val newValue =  getIncrement(parsedValue)
        resultText.text = newValue.toString()
    }

    /*
        if the current value of result_text is >1 && <6 increment by 1,
        if it is 6, do nothing,
        if it is null or any other value, set value to 1
    */
    private fun  getIncrement(value: Int?): Int? = when(value) {
        in 1..5 -> value?.inc()
        6 -> value
        else -> 1
    }
}
