package na.severinchik.lesson6.ui.dashboard

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import na.severinchik.lesson6.data.DataStorage
import na.severinchik.lesson6.data.User

class DashboardViewModel(context: Context) : ViewModel() {

    private var dataStorage: DataStorage = DataStorage()

    private val listUsers: List<User> = dataStorage.getData()

    private val _user = MutableLiveData<User>().apply { //currentMutableLiveData
        value = listUsers[0]
    }

//    private val __user = MutableLiveData<User>()
//    __user.postValue(listUsers[0])

    val user: LiveData<User> = _user

    var currentIndex = 0

    fun changeUser() {
        currentIndex++
        if (currentIndex > listUsers.lastIndex) currentIndex = 0

        _user.postValue(listUsers[currentIndex])
    }

    override fun onCleared() {
        super.onCleared()
    }
}