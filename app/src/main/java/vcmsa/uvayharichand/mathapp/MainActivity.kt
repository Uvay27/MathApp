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
                val number1EditText: EditText = findViewById(R.id.editTextNumber1)
                val number2EditText: EditText = findViewById(R.id.editTextNumber2)
                val calculateButton: Button = findViewById(R.id.buttonCalculate)
                val resultTextView: TextView = findViewById(R.id.textViewResult)

                // Setting up the button
                calculateButton.setOnClickListener {
                    val number1 = number1EditText.text.toString()
                    val number2 = number2EditText.text.toString()

                    if (number1.isNotEmpty() && number2.isNotEmpty()) {
                        val sum = number1.toDouble() + number2.toDouble()
                        resultTextView.text = "Result: $sum"

                        // you can display the result using a Toast
                        Toast.makeText(this, "Sum: $sum", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Please enter both numbers.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }