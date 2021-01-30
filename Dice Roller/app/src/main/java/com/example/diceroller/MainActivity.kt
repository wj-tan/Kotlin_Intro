package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This activity alllows user to roll a dice and view the result
 * on the screen
 * Ctrl+Alt+L to format code
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val diceImage : ImageView = findViewById(R.id.imageView)

        diceImage.setImageResource(R.drawable.dice_1)
        rollButton.setOnClickListener {
            rollDice()

            //val resultTextView: TextView = findViewById(R.id.textView)
            //resultTextView.text = "6"

            //val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            //toast.show()
            //Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show() Alternative code saves 1 line
        }
    }

    private fun rollDice() {
        // Create new Dice object wiht 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //val luckyNumber = 3

        /*
        if (diceRoll == luckyNumber) {
            Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
        } else if (diceRoll == 1) {
            Toast.makeText(this, "You Rolled a ${diceRoll.toString()}. Try again!", Toast.LENGTH_SHORT).show()
        } else if (diceRoll == 2) {
            Toast.makeText(this, "You Rolled a ${diceRoll.toString()}. Try again!", Toast.LENGTH_SHORT).show()
        } else if (diceRoll == 4) {
            Toast.makeText(this, "You Rolled a ${diceRoll.toString()}. Try again!", Toast.LENGTH_SHORT).show()
        } else if (diceRoll == 5) {
            Toast.makeText(this, "You Rolled a ${diceRoll.toString()}. Try again!", Toast.LENGTH_SHORT).show()
        } else if (diceRoll == 6) {
            Toast.makeText(this, "You Rolled a ${diceRoll.toString()}. Try again!", Toast.LENGTH_SHORT).show()
        }*/

        /* Alternative if else with when
        when (diceRoll) {
            luckyNumber -> Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
            1 -> Toast.makeText(this, "You Rolled a ${diceRoll.toString()}. Try again!", Toast.LENGTH_SHORT).show()
            2 -> Toast.makeText(this, "You Rolled a ${diceRoll.toString()}. Try again!", Toast.LENGTH_SHORT).show()
            4 -> Toast.makeText(this, "You Rolled a ${diceRoll.toString()}. Try again!", Toast.LENGTH_SHORT).show()
            5 -> Toast.makeText(this, "You Rolled a ${diceRoll.toString()}. Try again!", Toast.LENGTH_SHORT).show()
            6 -> Toast.makeText(this, "You Rolled a ${diceRoll.toString()}. Try again!", Toast.LENGTH_SHORT).show()
        }*/

        // Update the screen with the dice roll
        //val resultTextView: TextView = findViewById(R.id.textView)
        //resultTextView.text = diceRoll.toString()

        val diceImage : ImageView = findViewById(R.id.imageView)

        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }

        /* A more Concised version
        val drawableResource = when (diceRoll) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_1
        3 -> R.drawable.dice_1
        4 -> R.drawable.dice_1
        5 -> R.drawable.dice_1
        6 -> R.drawable.dice_1
        }

        diceImage.setImageResource(drawableResource)
         */
    }
}

/**
 * Roll the dice and update the screen with the result.
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}