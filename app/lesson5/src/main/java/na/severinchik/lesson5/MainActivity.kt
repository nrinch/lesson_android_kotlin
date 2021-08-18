package na.severinchik.lesson5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import na.severinchik.lesson5.FirstFragment.Companion.getInstance

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Intent(this, BottomNavigationActivity::class.java).also { startActivity(it) }

        val formattedByStringResouces = baseContext.resources.getString(R.string.price, 42)
        print("-->>$formattedByStringResouces")
    }

    fun menuClickListener(v: View) {
        val button = v as Button
        when (button.id) {
            R.id.am_btn_1 -> {
                route(FirstFragment.instanceWithParams(supportFragmentManager, "John", 42))
            }
            R.id.am_btn_1 -> {
                route(FirstFragment.instanceWithParams(routeToFirstFragment(), "John"))
            }
            R.id.am_btn_2 -> route(SecondFragment())
            R.id.am_btn_3 -> route(ThirdFragment())
        }
    }

    fun routeToFirstFragment() = { getInstance(supportFragmentManager) as FirstFragment }


    private fun route(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.am_fragment_container, fragment)
            .commit()
    }
}