package com.example.project3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EncryptActivity: AppCompatActivity() {

    private lateinit var textInput: EditText
    private lateinit var encryptButton: Button
    private lateinit var encryptedLabel: TextView
    private lateinit var backButton: Button
    private var shift: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encrypt)

        shift = intent.getIntExtra("SHIFT", 0)
        val encryption = Encryption(shift)

        textInput = findViewById(R.id.textInput)
        encryptButton = findViewById(R.id.encryptButton)
        encryptedLabel = findViewById(R.id.encryptedLabel)
        backButton = findViewById(R.id.backButton)

        encryptButton.setOnClickListener {
            val text = textInput.text.toString()
            encryptedLabel.text = encryption.encrypt(text)
        }

        backButton.setOnClickListener {
            finish()
        }
    }


}
