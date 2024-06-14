package com.example.project3

class Encryption(private var shift: Int) {

    fun encrypt(text: String): String {
        val encryptedText = StringBuilder()

        for (char in text) {
            // Determine if the character is an uppercase letter
            val shiftedChar = when (char) {
                in 'A'..'Z' -> {
                    // Convert the char to an integer, shift it, and convert back to char
                    ((char - 'A' + shift) % 26 + 'A'.code).toChar()
                }
                // Determine if the character is a lowercase letter
                in 'a'..'z' -> {
                    // Convert the char to an integer, shift it, and convert back to char
                    ((char - 'a' + shift) % 26 + 'a'.code).toChar()
                }
                // Leave non-alphabetic characters unchanged
                else -> {
                    char
                }
            }
            encryptedText.append(shiftedChar)
        }

        return encryptedText.toString()
    }
}
