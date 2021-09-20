package na.severinchik.lesson13.presentation.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import na.severinchik.lesson13.databinding.DialogDelCategoryBinding

class DeleteNoteDialog : DialogFragment() {

    var _binding: DialogDelCategoryBinding? = null
    private val binding: DialogDelCategoryBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogDelCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }
}
