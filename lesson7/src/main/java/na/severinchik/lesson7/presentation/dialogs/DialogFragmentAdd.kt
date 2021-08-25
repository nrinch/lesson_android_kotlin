package na.severinchik.lesson7.presentation.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import na.severinchik.lesson7.databinding.ActivityFragmentContainerBinding
import na.severinchik.lesson7.databinding.FragmentDialogAddBinding

class DialogFragmentAdd : BottomSheetDialogFragment() {

    companion object {
        val TAG: String = DialogFragmentAdd.javaClass.name
    }

    lateinit var binding: FragmentDialogAddBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDialogAddBinding.inflate(inflater, container, false)

        binding.fgaSave.setOnClickListener {
            dismiss()
        }
        return binding.root
    }
}