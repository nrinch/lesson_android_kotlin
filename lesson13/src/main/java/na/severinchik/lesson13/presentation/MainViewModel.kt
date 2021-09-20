package na.severinchik.lesson13.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import na.severinchik.lesson13.R
import na.severinchik.lesson13.data.localstorage.AppDatabase
import na.severinchik.lesson13.data.localstorage.dto.CategoryDto

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val appDatabase = AppDatabase.getInstance(application.applicationContext)
    private val daoCategories = appDatabase.daoCategory()

    private val _categories: MutableSharedFlow<List<CategoryDto>> = MutableSharedFlow()
    val categories: SharedFlow<List<CategoryDto>> = _categories

    init {


        viewModelScope.launch {
            daoCategories.insert(
                CategoryDto(
                    "Work",
                    application.applicationContext.resources.getColor(R.color.catClrRed),
                    0
                )
            )
        }
        fetchCategories()
    }

     fun fetchCategories() {
        viewModelScope.launch {
            daoCategories.getAll().collect { categories ->
                println("-->>> ViewModel $categories")

                _categories.emit(categories)
            }

        }
    }

}