package na.severinchik.lesson13.presentation.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import na.severinchik.lesson13.databinding.CategoryEditBinding
import na.severinchik.lesson13.databinding.ErrorDialogBinding

class ErrorDialog : DialogFragment() {

    var _binding: ErrorDialogBinding? = null
    private val binding: ErrorDialogBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ErrorDialogBinding.inflate(inflater, container, false)
        return binding.root
    }
}
