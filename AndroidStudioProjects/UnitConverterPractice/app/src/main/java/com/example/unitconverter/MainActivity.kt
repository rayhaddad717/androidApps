package com.example.unitconverter

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.unitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var select = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.spinner.onItemSelectedListener = object :

                AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            //position is the index of the string selected in the spinner(drop down menu)
            //i assign it to select to later use it in the calculate on click listener
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                select = position

            }

        }
        binding.conversionPic.setOnClickListener(){
       // binding.calculate.setOnClickListener() {

            val editableAns = binding.inputText.text
            val stringAns = editableAns.toString()
            var doubleAns = stringAns.toDoubleOrNull()
            if (doubleAns == null) {
                val toast = Toast.makeText(binding.spinner.context, "Did not enter a number", Toast.LENGTH_SHORT)
                toast.show()
            } else {
                binding.answer.text = when (select) {
                    1 -> mlToL(doubleAns).toString()
                    2 -> milesToInches(doubleAns).toString()
                    3 -> celsiusToKelvin(doubleAns).toString()
                    else -> {
                        val toast1= Toast.makeText(binding.root.context, "You did not make a selection", Toast.LENGTH_SHORT)
                        toast1.show()
                        0.0.toString()
                    }
                }
            }
            changePic(binding.conversionPic)
        }


    }
    public fun test(view: View){
        val toast=Toast.makeText(this,"hi",Toast.LENGTH_SHORT)
        toast.show()
    }
    public var i=1
    public fun changePic(view: ImageView){
        i =1
        when(i) {
            1->view.setImageResource(R.drawable.done_new)
            0->view.setImageResource(R.drawable.convert_button_new)
        }


    }
    public fun setImage(view:View){
        binding.conversionPic.setImageResource(R.drawable.convert_button_new)
    }


}

private fun mlToL(doubleAns: Double?): Double? {
    if (doubleAns != null) {
        return doubleAns * 0.001
    }
    return null

}

private fun milesToInches(doubleAns: Double?): Double? {
    if (doubleAns != null) {
        return doubleAns * 63360
    }
    return null
}

private fun celsiusToKelvin(doubleAns: Double?): Double? {
    if (doubleAns != null) {
        return doubleAns - 273
    }
    return null
}
/*
        val elements=arrayOf("ev to coul","ok","test")
      //  val arrayAdapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,elements)
      */


