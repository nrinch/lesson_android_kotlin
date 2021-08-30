package na.severinchik.lesson7.presentation.fragments.listFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import na.severinchik.lesson7.R
import na.severinchik.lesson7.databinding.FragmentListBinding

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
            openAddDialog()
        }
        viewModel.alcoholFlow.onEach {
//            adapter.submistList(it)
//            adapter.notifyAll()
        }.launchWhenResumed(lifecycleScope)


        return binding.root
    }

    private fun openAddDialog() {
        findNavController().navigate(R.id.action_listFragment_to_dialogFragmentAdd)
    }


}

fun <T> Flow<T>.launchWhenResumed(lifecycleCoroutineScope: LifecycleCoroutineScope){
    lifecycleCoroutineScope.launchWhenResumed {
        this@launchWhenResumed.collect()
    }
}