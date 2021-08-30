package na.severinchik.lesson7.presentation.fragments.settingFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import na.severinchik.lesson7.ContainerFragmentActivity
import na.severinchik.lesson7.R
import na.severinchik.lesson7.databinding.FragmentListBinding
import na.severinchik.lesson7.databinding.FragmentSettingsBinding
import na.severinchik.lesson7.presentation.fragments.listFragment.ListFragment
import na.severinchik.lesson7.presentation.fragments.listFragment.ListViewModel
import na.severinchik.lesson7.presentation.fragments.mainFragment.MainFragment

class SettingFragment : Fragment() {

    companion object {
        val TAG: String = SettingFragment.javaClass.name
    }

    private lateinit var binding: FragmentSettingsBinding
    private val viewModel: SettingViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        binding.fsLimitEt.setText(viewModel.getLimit().toString())

        binding.fsToList.setOnClickListener {
            openListFragment()
        }

        binding.fsLimitBtn.setOnClickListener {
            val limit = binding.fsLimitEt.text.toString().toInt()
            viewModel.saveLimit(limit)
            binding.fsLimitEt.setText(viewModel.getLimit().toString())

            Toast.makeText(requireContext(), "Saved", Toast.LENGTH_LONG).show()
        }

        return binding.root
    }

    private fun openListFragment() {
        findNavController().navigate(R.id.action_settingFragment_to_listFragment)
    }

}