package na.severinchik.lesson7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import na.severinchik.lesson7.databinding.ActivityFragmentContainerBinding

class ContainerFragmentActivity : AppCompatActivity() {

    lateinit var binding: ActivityFragmentContainerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentContainerBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
    }
}