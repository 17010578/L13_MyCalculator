package com.myapplicationdev.android.l13_mycalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var num = ""
    var total = 0.0
    var change = false
    var op = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonAC.setOnClickListener {
            num = ""
            tvResult.text = "0"
            change = false
        }
    }

    fun btnOnClick(view: View) {
        val btnSelected = view as Button
        if (change == false) {
            when (btnSelected.id) {
                button0.id -> num += "0"
                button1.id -> num += "1"
                button2.id -> num += "2"
                button3.id -> num += "3"
                button4.id -> num += "4"
                button5.id -> num += "5"
                button6.id -> num += "6"
                button7.id -> num += "7"
                button8.id -> num += "8"
                button9.id -> num += "9"
                buttonDot.id -> num += "."
            }
            tvResult.text = "$num"
            total = num.toDouble()
        } else {
            when (btnSelected.id) {
                button0.id -> num += "0"
                button1.id -> num += "1"
                button2.id -> num += "2"
                button3.id -> num += "3"
                button4.id -> num += "4"
                button5.id -> num += "5"
                button6.id -> num += "6"
                button7.id -> num += "7"
                button8.id -> num += "8"
                button9.id -> num += "9"
            }
            if (op == "+") {
                total = total.plus(num.toDouble())
            } else if (op == "-") {
                total = total.minus(num.toDouble())
            } else if (op == "*") {
                total = total.times(num.toDouble())
            } else if (op == "/") {
                total = total.div(num.toDouble())
            }
            tvResult.text = "$num"
        }
    }

    fun btnOnClicks(view: View) {
        num = ""
        val btnSelected = view as Button
        when (btnSelected.id) {
            buttonSlash.id -> op = "/"
            buttonSubtract.id -> op = "-"
            buttonMultiply.id -> op = "*"
            buttonAdd.id -> op = "+"
        }
        change = true
        tvResult.text = ""
    }

    fun btnEqualsClick(view: View) {
        tvResult.text = total.toString()
        num = total.toString()
    }

    fun btnDecClick(view: View) {
        if (change == false) {
            if (num.contains(".")) {
                Toast.makeText(this, "No 2 decimals allowed", Toast.LENGTH_SHORT).show()
            } else {
                num = num + "."
                tvResult.text = "$num"
            }
        } else if (change == true) {
            if (num.contains(".")) {
                Toast.makeText(this, "No 2 decimals allowed", Toast.LENGTH_SHORT).show()
            } else {
                num = num + "."
                tvResult.text = "$num"
            }
        }
    }
}
