package na.severinchik.lesson7.presentation.dialogs.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.onEach
import na.severinchik.lesson7.databinding.FragmentDialogListBinding
import na.severinchik.lesson7.presentation.data.AlcoholAdapter
import na.severinchik.lesson7.presentation.data.AlcoholItem
import na.severinchik.lesson7.presentation.data.AlcoholItemClickListener
import na.severinchik.lesson7.presentation.fragments.listFragment.launchWhenResumed
import org.koin.androidx.viewmodel.ext.android.viewModel


class DialogFragmentList : DialogFragment(), AlcoholItemClickListener {

    companion object {
        val TAG: String = DialogFragmentList.javaClass.name
    }

    lateinit var binding: FragmentDialogListBinding

    private val adapter: AlcoholAdapter = AlcoholAdapter(this)
    private val viewModelDialog: DialogListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDialogListBinding.inflate(inflater, container, false)

        binding.fglList.adapter = adapter

        viewModelDialog.data.onEach { list->
            adapter.submitList(list)
            adapter.notifyDataSetChanged()
        }.launchWhenResumed(lifecycleScope)

        return binding.root
    }

    override fun click(alcoholItem: AlcoholItem) {
        viewModelDialog.updateStateUser(alcoholItem)
        dismiss()
    }
}