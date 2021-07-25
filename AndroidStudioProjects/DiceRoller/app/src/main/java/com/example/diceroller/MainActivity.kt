package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Created a reference for the actual button in the program
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dices Rolled", Toast.LENGTH_SHORT)
            toast.show()
            rollDice()
        }
    }

    //Creating a private function to roll dice inside MainActivity class
    private fun rollDice() {
        val dice = Dice(6)
        val dice2= Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2=dice2.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        val secondTextView : TextView=findViewById(R.id.textView2)
        //Fun using Omar quotes ref
        /*
        if (diceRoll == 1) {

            resultTextView.text = "Good Morning"
            resultTextView.visibility = View.VISIBLE

        } else if (diceRoll == 3) {
            resultTextView.text = "wowowowowowowowow"
            resultTextView.visibility = View.VISIBLE
        } else if(diceRoll==4)
        {
            resultTextView.text= " Shou drast lyom"
        }
        else if(diceRoll==5){
            resultTextView.text="10x"
        }
        else
            resultTextView.text="goodbye"

         //   resultTextView.visibility = View.INVISIBLE
            */

        resultTextView.text = diceRoll.toString()
        secondTextView.text=diceRoll2.toString()
    }
}

//Creating a Dice Class
class Dice(private val sides: Int = 6) {
    public fun roll(): Int {
        return (1..6).random()
    }
}
