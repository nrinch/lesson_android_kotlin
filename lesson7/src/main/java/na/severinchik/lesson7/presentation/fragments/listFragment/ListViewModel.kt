package na.severinchik.lesson7.presentation.fragments.listFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import na.severinchik.lesson7.data.entity.Alcohol
import na.severinchik.lesson7.data.entity.toAlcoholItem
import na.severinchik.lesson7.data.repositories.AlcoRepositories
import na.severinchik.lesson7.data.room.InstanceAlcoDB
import na.severinchik.lesson7.domain.AlcoholUseCaseImpl
import na.severinchik.lesson7.presentation.data.AlcoholItem

class ListViewModel(useCaseImpl: AlcoholUseCaseImpl) : ViewModel() {


    private val _alcoholFlow: MutableSharedFlow<List<AlcoholItem>> = MutableSharedFlow()
    val alcoholFlow: SharedFlow<List<AlcoholItem>> = _alcoholFlow

    init {
        viewModelScope.launch {
            useCaseImpl.fetchData().collect { list ->
                _alcoholFlow.emit(list)
            }
        }
    }
}