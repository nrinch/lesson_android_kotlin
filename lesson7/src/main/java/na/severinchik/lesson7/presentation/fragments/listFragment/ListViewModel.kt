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
import na.severinchik.lesson7.data.repositories.AlcoRepositories
import na.severinchik.lesson7.data.room.InstanceAlcoDB

class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val db = InstanceAlcoDB.get(application)
    private val alcoRepositories = AlcoRepositories(db.alcoholDao())

    private val _alcoholFlow: MutableSharedFlow<List<Alcohol>> = MutableSharedFlow()
    val alcoholFlow: SharedFlow<List<Alcohol>> = _alcoholFlow

    init {
        viewModelScope.launch {
            alcoRepositories.getAll().collect {
                _alcoholFlow.emit(it)
            }
        }
    }
}