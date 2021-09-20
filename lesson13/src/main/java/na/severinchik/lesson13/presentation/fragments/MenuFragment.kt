package na.severinchik.lesson13.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import na.severinchik.lesson13.R
import na.severinchik.lesson13.databinding.FragmentMenuBinding
import na.severinchik.lesson13.presentation.MenuItem

private const val ID_CATEGORIES = 0

class MenuFragment : Fragment() {

    var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(layoutInflater, container, false)

        binding.backMenu.setOnClickListener {
            requireActivity().finish()
        }

        return binding.root

    }


    private fun toCurrentCategory(menuItem: MenuItem) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.menu_fragment_container, getMenuFragment(menuItem.idFragment))
            .commit()
    }

    private fun getMenuFragment(id: Int): Fragment {
        return when (id) {
            ID_CATEGORIES -> MenuCategoriesFragment()
            else -> MenuCategoriesFragment()
        }
    }
}