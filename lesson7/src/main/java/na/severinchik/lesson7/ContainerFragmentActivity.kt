package na.severinchik.lesson7

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import na.severinchik.lesson7.databinding.ActivityFragmentContainerBinding
import na.severinchik.lesson7.presentation.fragments.mainFragment.MainFragment
import na.severinchik.lesson7.presentation.fragments.settingFragment.SettingFragment

class ContainerFragmentActivity : AppCompatActivity() {

    lateinit var binding: ActivityFragmentContainerBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentContainerBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
    }
}
