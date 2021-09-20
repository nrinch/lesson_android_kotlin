package na.severinchik.lesson13.presentation

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import na.severinchik.lesson13.R
import na.severinchik.lesson13.databinding.ActivityMainBinding
import na.severinchik.lesson13.databinding.FragmentAddNoteBinding

class MainActivity : AppCompatActivity() {


    var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
    }
}