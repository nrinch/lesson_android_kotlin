package na.severinchik.leeson4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("-->>onCreate")
    }

    override fun onStart() {
        super.onStart()
        println("-->>onStart")
    }

    override fun onResume() {
        super.onResume()
        println("-->>onResume")
    }

    override fun onRestart() {
        super.onRestart()
        println("-->>onRestart")
    }

    override fun onPause() {
        super.onPause()
        println("-->>onPause")
    }

    override fun onStop() {
        super.onStop()
        println("-->>onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("-->>onDestroy")
    }
}