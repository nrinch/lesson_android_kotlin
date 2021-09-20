package na.severinchik.lesson13.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import na.severinchik.lesson13.R
import na.severinchik.lesson13.databinding.CategoryAddBinding
import na.severinchik.lesson13.databinding.FragmentAddNoteBinding

class AddNoteFragment : Fragment() {

    var _binding: FragmentAddNoteBinding? = null
    private val binding: FragmentAddNoteBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)


        binding.buttonAddNote.setOnClickListener {
            backToList()
        }
        binding.backMenu.setOnClickListener {
            backToList()
        }

        return binding.root

    }

    private fun backToList() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, NotesFragment())
            .commit()
    }
}