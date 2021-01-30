package com.example.tiptime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

//Reference https://developer.android.com/courses/pathways/android-basics-kotlin-unit-2-pathway-1

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    /*
    Old way with findViewById()
    val myButton: Button = findViewById(R.id.my_button)
    myButton.text = "A button"

    Better way with view binding
    val myButton: Button = binding.myButton
    myButton.text = "A button"

    Best way with view binding and no extra variable
    binding.myButton.text = "A button"
     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{ calculateTip() }
    }

    fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDouble()
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.option_fifteen_percent -> 0.15
            R.id.option_eighteen_percent -> 0.18
            else -> 0.20
        }
        var tip = tipPercentage * cost
        val roundUp = binding.roundUpSwitch.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
        //%s is where the formatted currency will be inserted

    }
}