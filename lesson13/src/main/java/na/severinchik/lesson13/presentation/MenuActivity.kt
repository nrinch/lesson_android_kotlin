package na.severinchik.lesson13.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import na.severinchik.lesson13.R
import na.severinchik.lesson13.presentation.fragments.MenuFragment

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.menu_fragment_container, MenuFragment())
            .commit()

    }
}