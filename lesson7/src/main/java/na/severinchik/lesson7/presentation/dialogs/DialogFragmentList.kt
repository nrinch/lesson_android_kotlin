package na.severinchik.lesson7.presentation.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import na.severinchik.lesson7.databinding.FragmentDialogListBinding

class DialogFragmentList : DialogFragment() {

    companion object {
        val TAG: String = DialogFragmentList.javaClass.name
    }

    lateinit var binding: FragmentDialogListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDialogListBinding.inflate(inflater, container, false)

        return binding.root
    }
}