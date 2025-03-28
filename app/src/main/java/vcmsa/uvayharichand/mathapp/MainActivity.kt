package vcmsa.uvayharichand.mathapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Finding the views by their IDs
        val firstNumberEditText: EditText = findViewById(R.id.editTextNumber1)
        val secondNumberEditText: EditText = findViewById(R.id.editTextNumber2)
        val resultTextView: TextView = findViewById(R.id.textViewResult)

        // Button for Addition
        val addButton: Button = findViewById(R.id.buttonAdd)
        addButton.setOnClickListener {
            performOperation(firstNumberEditText, secondNumberEditText, resultTextView, "add")
        }

        // Button for Subtraction
        val subtractButton: Button = findViewById(R.id.buttonSubtract)
        subtractButton.setOnClickListener {
            performOperation(firstNumberEditText, secondNumberEditText, resultTextView, "subtract")
        }

        // Button for Multiplication
        val multiplyButton: Button = findViewById(R.id.buttonMultiply)
        multiplyButton.setOnClickListener {
            performOperation(firstNumberEditText, secondNumberEditText, resultTextView, "multiply")
        }

        // Button for Division
        val divideButton: Button = findViewById(R.id.buttonDivide)
        divideButton.setOnClickListener {
            performOperation(firstNumberEditText, secondNumberEditText, resultTextView, "divide")
        }
    }

    // Function to perform the selected operation
    private fun performOperation(
        number1EditText: EditText,
        number2EditText: EditText,
        resultTextView: TextView,
        operation: String
    ) {
        val number1Text = number1EditText.text.toString()
        val number2Text = number2EditText.text.toString()

        if (number1Text.isNotEmpty() && number2Text.isNotEmpty()) {
            try {
                val number1 = number1Text.toDouble()
                val number2 = number2Text.toDouble()
                val result: Double

                when (operation) {
                    "add" -> result = number1 + number2
                    "subtract" -> result = number1 - number2
                    "multiply" -> result = number1 * number2
                    "divide" -> {
                        if (number2.toInt() != 0) {
                            result = number1 / number2
                        } else {
                            resultTextView.text = "Cannot divide by zero"
                            return
                        }
                    }
                    else -> {
                        resultTextView.text = "Invalid operation"
                        return
                    }
                }

                resultTextView.text = "Result: $result"
                Toast.makeText(this, "Result: $result", Toast.LENGTH_SHORT).show()

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Invalid input. Please enter valid numbers.", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Please enter both numbers.", Toast.LENGTH_SHORT).show()
        }
    }
}

