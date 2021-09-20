package na.severinchik.lesson13.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import na.severinchik.lesson13.databinding.FragmentAddNoteBinding
import na.severinchik.lesson13.databinding.FragmentMenuBinding

class MenuFragment: Fragment() {

    var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root

    }
}