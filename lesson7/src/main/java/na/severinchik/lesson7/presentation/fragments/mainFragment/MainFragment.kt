package na.severinchik.lesson7.presentation.fragments.mainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import na.severinchik.lesson7.R
import na.severinchik.lesson7.databinding.FragmentMainBinding


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
            openSettingFragment()
        }
        binding.fmAddBtn.setOnClickListener {
            openAddDialog()
        }
        return binding.root
    }


    private fun openSettingFragment() {
        findNavController().navigate(R.id.action_mainFragment_to_settingFragment)
    }

    private fun openAddDialog() {
        findNavController().navigate(R.id.action_mainFragment_to_dialogFragmentList)
    }

}