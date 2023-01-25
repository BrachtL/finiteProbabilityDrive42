package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//This activity allows the user to roll a dice and view the result on the screen.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        // Create new Dice object with 6 sides
        val dice6 = Dice(6)

        rollButton.setOnClickListener {
            //val toast = Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT)
            //toast.show()

            val resultTextView: TextView = findViewById(R.id.textView)

            //Roll the dice and update the screen with the result
            resultTextView.text = dice6.roll().toString()

        }
    }
}

class Dice (private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}

//improvements for this app
    //choose how many faces someone wants the dice to have
    //if no value is entered, make it heads and tails and make a toast to say this is the default