package na.severinchik.lesson13.presentation.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import na.severinchik.lesson13.databinding.CategoryAddBinding

class AddCategoryDialog : DialogFragment() {

    var _binding: CategoryAddBinding? = null
    private val binding: CategoryAddBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CategoryAddBinding.inflate(inflater, container, false)
        return binding.root
    }
}