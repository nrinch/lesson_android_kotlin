package na.severinchik.lesson13.presentation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collect
import na.severinchik.lesson13.R
import na.severinchik.lesson13.databinding.ActivityMainBinding
import na.severinchik.lesson13.presentation.adapters.CategoriesMainScreenAdapter
import na.severinchik.lesson13.presentation.fragments.NotesFragment

class MainActivity : AppCompatActivity() {


    var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()
    private val adapter = CategoriesMainScreenAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        openAllNotes()

        binding.amMenu.setOnClickListener {
            Intent(this, MenuActivity::class.java).apply {
                startActivity(this)
            }
        }
        binding.buttonAllCategoris.categoryButton.setOnClickListener {
            openAllNotes()
        }

        binding.recyclerViewCategory.adapter = adapter

        viewModel.fetchCategories()

        lifecycleScope.launchWhenCreated {
            viewModel.categories.collect {
                println("-->>> $it")
                adapter.submitList(it)
                adapter.notifyDataSetChanged()
            }

        }
    }

    private fun openAllNotes() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, NotesFragment())
            .commit()
    }
}