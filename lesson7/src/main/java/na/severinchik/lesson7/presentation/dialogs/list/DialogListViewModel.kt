package na.severinchik.lesson7.presentation.dialogs.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import na.severinchik.lesson7.domain.AlcoholUseCaseImpl
import na.severinchik.lesson7.presentation.data.AlcoholItem

class DialogListViewModel(useCaseImpl: AlcoholUseCaseImpl) : ViewModel() {

    val useCase by lazy { useCaseImpl }

    private val _data: MutableSharedFlow<List<AlcoholItem>> = MutableSharedFlow()
    val data: SharedFlow<List<AlcoholItem>> = _data

    init {
        fetch()
    }

    fun fetch() {
        viewModelScope.launch {
            useCase.fetchData().collect { list ->
                _data.emit(list)
            }
        }
    }

    fun updateStateUser(alcoholItem: AlcoholItem) {
        viewModelScope.launch(Dispatchers.IO) {

            useCase.updateStateUser(alcoholItem.id)

        }
    }
}