package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private var newOp = true
    var oldNumber = ""
    var op = "+"
    var isNewOp = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickNumber(view: View) {
        val editText = findViewById<TextView>(R.id.editText)
        if(isNewOp)
            editText.text = ""
        isNewOp = false
        var button = view as Button
        var buClick = editText.text.toString()


        when (button.id) {
            R.id.button_one -> buClick += "1"
            R.id.button_two -> buClick += "2"
            R.id.button_three -> buClick += "3"
            R.id.button_four -> buClick += "4"
            R.id.button_five -> buClick += "5"
            R.id.button_six -> buClick += "6"
            R.id.button_seven -> buClick += "7"
            R.id.button_eight -> buClick += "8"
            R.id.button_nine -> buClick += "9"
            R.id.button_zero -> buClick += "0"
            R.id.button_reverse -> buClick = "-$buClick"
        }

        editText.text = buClick
    }

    fun operatorAction(view: View) {
        isNewOp = true
        oldNumber = findViewById<TextView>(R.id.editText).text.toString()
        var buttonSelect = view as Button
        when (buttonSelect.id){
            R.id.button_multiplication -> {op = "*"}
            R.id.button_division -> {op = "/"}
            R.id.button_addition -> {op = "+"}
            R.id.button_subtraction -> {op = "-"}
        }
    }

    fun clearEntryAction(view: View) {
        val editText = findViewById<TextView>(R.id.editText)
        editText.text = ""
        newOp = true
        oldNumber = ""
        op = "+"
        isNewOp = true
    }

    fun clearAction(view: View) {
        val editText = findViewById<TextView>(R.id.editText)
        editText.text = "0"
        isNewOp = true
    }

    fun backSpaceAction(view: View) {
        val editText = findViewById<TextView>(R.id.editText)
        val buClick = editText.text.toString()
        if(buClick.length >= 1)
            editText.text = buClick.substring(0, buClick.length - 1)
    }

    fun equalsAction(view: View) {
        var newNumber = findViewById<TextView>(R.id.editText).text.toString()
        var result = 0.0
        when(op){
            "+" -> {result =  oldNumber.toDouble() + newNumber.toDouble()}
            "*" -> {result =  oldNumber.toDouble() * newNumber.toDouble()}
            "/" -> {result =  oldNumber.toDouble() / newNumber.toDouble()}
            "-" -> {result =  oldNumber.toDouble() - newNumber.toDouble()}
        }
        findViewById<TextView>(R.id.editText).text = result.toString()
    }


}