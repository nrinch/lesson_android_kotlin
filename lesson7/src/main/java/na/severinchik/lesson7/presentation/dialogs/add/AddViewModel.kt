package na.severinchik.lesson7.presentation.dialogs.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import na.severinchik.lesson7.data.entity.Alcohol
import na.severinchik.lesson7.data.repositories.AlcoRepositories
import na.severinchik.lesson7.data.room.InstanceAlcoDB
import na.severinchik.lesson7.domain.AlcoholUseCaseImpl

class AddViewModel(private val useCaseImpl: AlcoholUseCaseImpl) : ViewModel() {

    fun create(alcohol: Alcohol) {

        viewModelScope.launch {
            useCaseImpl.insert(alcohol)
        }
    }
}