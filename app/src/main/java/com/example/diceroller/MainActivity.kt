package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//This activity allows the user to roll a dice and view the result on the screen.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        // Create new Dice object with 6 sides
        //val dice6 = Dice(6)


        rollButton.setOnClickListener {
            val inputSides: EditText = findViewById(R.id.editTextNumberSides)

            val resultTextView: TextView = findViewById(R.id.textView)
            /*  //tests to understand the error inputSides.text == "string"
                //inputSides.text is printable, but it is not a string, it is an Editable type
            println(inputSides.text.equals("(number of sides)"))
            println(inputSides.text)
            println("aa" == "aa")
            println("aa".equals("aa"))
            println(inputSides.text.toString() == "(number of sides)")
            */

            if(inputSides.text.toString() == "") {
                val dice2 = Dice(2)
                resultTextView.text = dice2.roll().toString()
                val toast = Toast.makeText(this, "Input not received, considering 2 side dice", Toast.LENGTH_SHORT)
                toast.show()

            } else if(inputSides.text.toString() == "0") {
                val toast = Toast.makeText(
                    this,
                    "Please enter a number greater than zero",
                    Toast.LENGTH_SHORT
                )
                toast.show()
            } else {
                val dicex = Dice(Integer.parseInt(inputSides.text.toString()))
                //Roll the dice and update the screen with the result
                resultTextView.text = dicex.roll().toString()
            }




        }
    }
}

class Dice (private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}

//improvements for this app
    //play more than one dice
        //logic (backend)
        //layout to show up to 50(?) results in the screen and the sum of them all
    //let the user add some fix number (RPG purposes)
        //create the field to receive this number
        //logic (backend)
    //let the user create presets (quantity of dices + fix number to sum with)
        //layout
        //logic (backend)
    //pick up a random card
        //layout
        //logic
    //layout to heads and tails
    //menu to chose what user wants: (RPG preset, card, lottery preset)

//done
    //choose how many faces someone wants the dice to have
    //if no value is entered, make it heads and tails and make a toast to say this is the default