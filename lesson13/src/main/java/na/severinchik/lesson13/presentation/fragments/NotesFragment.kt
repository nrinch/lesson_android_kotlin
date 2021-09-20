package na.severinchik.lesson13.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import na.severinchik.lesson13.R
import na.severinchik.lesson13.databinding.FragmentAddNoteBinding
import na.severinchik.lesson13.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    var _binding: FragmentNotesBinding? = null
    private val binding: FragmentNotesBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotesBinding.inflate(layoutInflater, container, false)

        binding.buttonAddNote.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AddNoteFragment())
                .commit()
        }

        return binding.root

    }

    fun toDetailsOfNote() {
        parentFragmentManager.beginTransaction()
            /// TODO add param note to NoteFragment()
            .replace(R.id.fragment_container, NoteFragment())
            .commit()
    }
}