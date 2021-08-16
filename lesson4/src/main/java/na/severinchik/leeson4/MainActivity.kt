package na.severinchik.leeson4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var operation: CalcOperation? = null

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this,LifecycleActivity::class.java))

        val equal: Button = findViewById(R.id.am_operation_equal)
        equal.setOnClickListener {
            findViewById<TextView>(R.id.am_output_tv).text = "Bu-ga-ga"
        }
    }

    fun operationEqual(v: View) {
        findViewById<TextView>(R.id.am_output_tv).text = "Bu-ga-ga"
    }

    fun calcOperation(v: View) {
        val button = v as Button
        when(button.text){
            "+" -> operation = CalcOperation.Plus
            "-" -> operation = CalcOperation.Minus
            "/" -> operation = CalcOperation.Mult
            "*" -> operation = CalcOperation.Div
        }
        val outputField =  findViewById<TextView>(R.id.am_output_tv)
        outputField.text = "${outputField.text} ${operation?.type}" ?: ""

    }
}

sealed class CalcOperation(val type: String) {
    object Plus : CalcOperation("+")
    object Minus : CalcOperation("-")
    object Mult : CalcOperation("*")
    object Div : CalcOperation("/")
}
