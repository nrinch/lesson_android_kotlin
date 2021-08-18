package na.severinchik.leeson4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var operation: CalcOperation? = null

    private var argument1: Int = 0
    private var argument2: Int = 0

    private lateinit var outputField: TextView

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        outputField = findViewById(R.id.am_output_tv)

        startActivity(Intent(this, LifecycleActivity::class.java))

        val equal: Button = findViewById(R.id.am_operation_equal)
        equal.setOnClickListener {
            findViewById<TextView>(R.id.am_output_tv).text = "Bu-ga-ga"
        }
    }

    fun operationEqual(v: View) {
        var result = -1

        when (operation) {
            CalcOperation.Div -> result = argument1 / argument2
            CalcOperation.Minus -> TODO()
            CalcOperation.Mult -> TODO()
            CalcOperation.Plus -> TODO()
            null -> TODO()
        }
        outputField.text = result.toString()

        argument1 = 0
        argument2 = 0
        operation = null
    }

    fun calcOperation(v: View) {
        val button = v as Button
        when (button.text) {
            "+" -> operation = CalcOperation.Plus
            "-" -> operation = CalcOperation.Minus
            "/" -> operation = CalcOperation.Mult
            "*" -> operation = CalcOperation.Div
        }
        val outputField = findViewById<TextView>(R.id.am_output_tv)
        outputField.text = "${outputField.text} ${operation?.type}" ?: ""
        argument1 = outputField.text.toString().toInt()
        outputField.text = ""
    }

    fun inputNumbers(v: View) {
        val button = v as Button
        when (button.id) {
            R.id.am_number_0 -> setAgrs(0)
            R.id.am_number_1 -> setAgrs(1)
            R.id.am_number_2 -> setAgrs(2)
            R.id.am_number_3 -> setAgrs(3)
            R.id.am_number_4 -> setAgrs(4)
            R.id.am_number_5 -> setAgrs(5)
            R.id.am_number_6 -> setAgrs(6)
            R.id.am_number_7 -> setAgrs(7)
            R.id.am_number_8 -> setAgrs(8)
            R.id.am_number_9 -> setAgrs(9)
        }
    }

    private fun setAgrs(number: Int) {
        outputField.text = "${outputField.text}$number"

        if (operation != null) {
            argument2 = number
        } else {
            argument1 = number
        }
    }
}

sealed class CalcOperation(val type: String) {
    object Plus : CalcOperation("+")
    object Minus : CalcOperation("-")
    object Mult : CalcOperation("*")
    object Div : CalcOperation("/")
}
