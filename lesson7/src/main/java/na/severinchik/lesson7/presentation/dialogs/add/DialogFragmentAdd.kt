package na.severinchik.lesson7.presentation.dialogs.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import na.severinchik.lesson7.data.entity.Alcohol
import na.severinchik.lesson7.databinding.FragmentDialogAddBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DialogFragmentAdd : BottomSheetDialogFragment() {

    companion object {
        val TAG: String = DialogFragmentAdd.javaClass.name
    }

    lateinit var binding: FragmentDialogAddBinding

    private val viewModel: AddViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDialogAddBinding.inflate(inflater, container, false)

        binding.fgaSave.setOnClickListener {
            viewModel.create(
                Alcohol(
                    name = binding.fgaName.text.toString(),
                    power = binding.fgaPower.text.toString().toInt(),
                    halfLife = binding.fgaHalfLife.text.toString().toInt()
                )
            )
            dismiss()
        }
        return binding.root
    }
}