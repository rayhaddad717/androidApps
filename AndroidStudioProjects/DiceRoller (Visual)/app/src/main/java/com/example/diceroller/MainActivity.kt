package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Created a reference for the actual button in the program
        val rollButton: Button = findViewById(R.id.button)
        rollDice()

        
        //Code to be executed when the button is clicked
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dices Rolled", Toast.LENGTH_SHORT)
            toast.show()
            rollDice()
        }
    }

    //Creating a private function to roll dice inside MainActivity class
    private fun rollDice() {
        val dice = Dice(6)
        val dice2 = Dice(6)

        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()

        //Create reference to the ImageView containing Dice image
        val diceImage: ImageView = findViewById(R.id.dice1)
        val diceImage2: ImageView = findViewById(R.id.dice2)

        //Display the correct image
        diceImage.setImageResource(setId(diceRoll))
        diceImage2.setImageResource(setId(diceRoll2))

        //Change content description so the app can read aloud the number rolled
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll.toString()

    }


}
//Returns the Id of the image to be displayed given the dice rolled number
private fun setId(roll: Int): Int {
    return when (roll) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

}


//Creating a Dice Class
class Dice(private val sides: Int = 6) {
    public fun roll(): Int {
        return (1..6).random()
    }
}
