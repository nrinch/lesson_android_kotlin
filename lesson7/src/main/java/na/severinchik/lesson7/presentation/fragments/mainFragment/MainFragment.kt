package na.severinchik.lesson7.presentation.fragments.mainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import na.severinchik.lesson7.R
import na.severinchik.lesson7.databinding.FragmentMainBinding
import na.severinchik.lesson7.presentation.dialogs.DialogFragmentAdd
import na.severinchik.lesson7.presentation.dialogs.DialogFragmentList
import na.severinchik.lesson7.presentation.fragments.listFragment.ListFragment
import na.severinchik.lesson7.presentation.fragments.settingFragment.SettingFragment


class MainFragment : Fragment() {

    companion object {
        val TAG: String = MainFragment.javaClass.name
    }

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.fmSettingBtn.setOnClickListener {
            openSettingFragment(parentFragmentManager)
        }
        binding.fmAddBtn.setOnClickListener {
            activity?.supportFragmentManager?.let { fragmentManager ->
                DialogFragmentList().show(
                    fragmentManager,
                    DialogFragmentList.TAG
                )
            }
        }
        return binding.root
    }


    private fun openSettingFragment(fragmentManager: FragmentManager) {
        fragmentManager
            .beginTransaction()
            .replace(R.id.cfa_fragment_container, SettingFragment())
            .addToBackStack(TAG)
            .commit()

        Toast.makeText(activity?.baseContext, "Success", Toast.LENGTH_LONG).show()
    }

}