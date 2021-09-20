package na.severinchik.lesson13.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import na.severinchik.lesson13.databinding.FragmentAddNoteBinding
import na.severinchik.lesson13.databinding.FragmentMenuBinding
import na.severinchik.lesson13.databinding.FragmentMenuCategoriesBinding

class MenuCategoriesFragment : Fragment() {

    var _binding: FragmentMenuCategoriesBinding? = null
    private val binding: FragmentMenuCategoriesBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuCategoriesBinding.inflate(layoutInflater, container, false)
        return binding.root

    }
}