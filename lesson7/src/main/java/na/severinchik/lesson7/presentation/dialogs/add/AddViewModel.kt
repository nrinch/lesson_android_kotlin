package na.severinchik.lesson7.presentation.dialogs.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import na.severinchik.lesson7.data.entity.Alcohol
import na.severinchik.lesson7.data.repositories.AlcoRepositories
import na.severinchik.lesson7.data.room.InstanceAlcoDB

class AddViewModel(application: Application) : AndroidViewModel(application) {

    private val db = InstanceAlcoDB.get(application)
    private val alcoRepositories = AlcoRepositories(db.alcoholDao())

    fun create(alcohol: Alcohol) {

        viewModelScope.launch {
            alcoRepositories.insert(alcohol)
        }
    }
}