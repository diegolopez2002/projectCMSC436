package com.example.project3


import android.annotation.SuppressLint


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.project3.R.*

class MainActivity : AppCompatActivity() {

    private lateinit var numberInput: EditText
    private lateinit var submitButton: Button
    private lateinit var errorLabel: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        numberInput = findViewById(id.numberInput)
        submitButton = findViewById(id.submitButton)
        errorLabel = findViewById(id.errorLabel)

        submitButton.setOnClickListener {
            val input = numberInput.text.toString()
            if (TextUtils.isEmpty(input) || !isValidNumber(input.toInt())) {
                errorLabel.text = "Please enter an integer between 1 and 25 only"
                errorLabel.visibility = TextView.VISIBLE
            } else {
                val shift = input.toInt()
                val intent = Intent(this, EncryptActivity::class.java).apply {
                    putExtra("SHIFT", shift)
                }
                startActivity(intent)
            }
        }
    }

    private fun isValidNumber(number: Int): Boolean {
        return number in 1..25
    }
}
