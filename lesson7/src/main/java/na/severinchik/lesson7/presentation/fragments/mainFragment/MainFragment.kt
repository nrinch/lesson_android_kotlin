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

        binding.fmProgress.max = viewModel.getLimit()
        binding.fmSettingBtn.setOnClickListener {
            openSettingFragment()
        }
        binding.fmAddBtn.setOnClickListener {
            openAddDialog()
        }
        binding.fmUpdate.setOnClickListener {
            val current: Double = viewModel.getState().toDouble()
            val max: Double = viewModel.getLimit().toDouble()

            if (current < max) {
                val result: Double = 100 - ((current / max) * 100.0)
                binding.fmProgressValue.text = "$result %"
                binding.fmProgress.progress = (max - current).toInt()
            } else {
                binding.fmProgressValue.text = "$max %"
                binding.fmProgress.progress = max.toInt()
            }
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