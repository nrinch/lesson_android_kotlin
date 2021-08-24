package na.severinchik.lesson6.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import na.severinchik.lesson6.data.DataStorage
import na.severinchik.lesson6.data.User

class HomeViewModel : ViewModel() {

    val dataStorage = DataStorage()

    private val mutableLiveData = MutableLiveData<List<User>>().apply {
        value = dataStorage.getData()
    }
    val liveData: LiveData<List<User>> = mutableLiveData
}