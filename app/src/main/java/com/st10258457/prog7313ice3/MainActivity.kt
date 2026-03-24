package com.st10258457.prog7313ice3

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.st10258457.prog7313ice3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val number1 = binding.inputNumber1
        val number2 = binding.inputNumber2
        val answer = binding.tvAnswer

        binding.btnAdd.setOnClickListener() {
            val value = convertToNum(number1) + convertToNum(number2)
            answer.text = displayAnswer("addition", value)
        }

        binding.btnSubtract.setOnClickListener() {
            val value = convertToNum(number1) - convertToNum(number2)
            answer.text = displayAnswer("subtraction", value)
        }

        binding.btnMultiply.setOnClickListener() {
            val value = convertToNum(number1) * convertToNum(number2)
            answer.text = displayAnswer("multiplication", value)
        }

        binding.btnDivide.setOnClickListener() {
            if (convertToNum(number2) == 0.0) {
                answer.text = "Cannot divide by zero"
            } else {
                val value = convertToNum(number1) / convertToNum(number2)
                answer.text = displayAnswer("division", value)
            }
        }
    }

    fun convertToNum(input: EditText): Double {
        return input.text.toString().toDoubleOrNull() ?: 0.0
    }

    fun displayAnswer(operation: String, answer: Double): String {
        return "The result of $operation is $answer"
    }
}