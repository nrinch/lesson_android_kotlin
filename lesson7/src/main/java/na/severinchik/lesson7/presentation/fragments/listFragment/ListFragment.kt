package na.severinchik.lesson7.presentation.fragments.listFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import na.severinchik.lesson7.R
import na.severinchik.lesson7.databinding.FragmentListBinding
import na.severinchik.lesson7.presentation.data.AlcoholAdapter
import na.severinchik.lesson7.presentation.data.AlcoholItem
import na.severinchik.lesson7.presentation.data.AlcoholItemClickListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment(), AlcoholItemClickListener {

    companion object {
        val TAG: String = ListFragment.javaClass.name
    }

    private val adapter: AlcoholAdapter = AlcoholAdapter(this)

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        binding.flAdd.setOnClickListener {
            openAddDialog()
        }

        binding.flList.adapter = adapter

        viewModel.alcoholFlow.onEach { list->
            adapter.submitList(list)
            adapter.notifyDataSetChanged()
        }.launchWhenResumed(lifecycleScope)


        return binding.root
    }

    private fun openAddDialog() {
        findNavController().navigate(R.id.action_listFragment_to_dialogFragmentAdd)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun click(alcoholItem: AlcoholItem) = Unit

}

fun <T> Flow<T>.launchWhenResumed(lifecycleCoroutineScope: LifecycleCoroutineScope) {
    lifecycleCoroutineScope.launchWhenResumed {
        this@launchWhenResumed.collect()
    }
}