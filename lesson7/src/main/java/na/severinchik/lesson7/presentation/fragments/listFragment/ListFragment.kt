package na.severinchik.lesson7.presentation.fragments.listFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import na.severinchik.lesson7.databinding.FragmentListBinding
import na.severinchik.lesson7.databinding.FragmentMainBinding
import na.severinchik.lesson7.presentation.dialogs.DialogFragmentAdd
import na.severinchik.lesson7.presentation.fragments.mainFragment.MainViewModel

class ListFragment : Fragment() {

    companion object {
        val TAG: String = ListFragment.javaClass.name
    }

    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)

        binding.flAdd.setOnClickListener {
            activity?.supportFragmentManager?.let { fragmentManager ->
                openAddDialog(fragmentManager)
            }
        }

        return binding.root
    }

    private fun openAddDialog(fragmentManager: FragmentManager) {
        DialogFragmentAdd().show(fragmentManager, DialogFragmentAdd.TAG)
    }

}