package com.example.tiptime

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        //to double or null if the user didn't input a number in the service cost but then presses calculate
        val cost = stringInTextField.toDoubleOrNull()
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            //cannot write binding.optionTwentyPercent since selectedId is of type int while binding... is of type button
            // also R.id.option_twenty_percent is an int
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        //if the user pressed calculate without entering a service cost
        if(cost==null||cost==0.0){
            displayTip(0.0)
            val toast = Toast.makeText(this, "Please input a service cost!", Toast.LENGTH_SHORT)
            toast.show()
            return
        }
        var tip = cost * tipPercentage
        if (binding.roundUpSwitch.isChecked) {
            //ceil() method will round up my double
            tip = kotlin.math.ceil(tip)
        }
        displayTip(tip)

    }
    private fun displayTip(tip:Double){

        //formatted tip will be inserted in %s in the tip_result string in strings.xml
        val formattedTip= NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text=getString(R.string.tip_result, formattedTip)
    }


}