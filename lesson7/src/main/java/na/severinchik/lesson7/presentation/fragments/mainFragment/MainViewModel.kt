package na.severinchik.lesson7.presentation.fragments.mainFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import na.severinchik.lesson7.data.storage.SettingStorage

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val settingStorage by lazy { SettingStorage(application = application) }

    fun getLimit() = settingStorage.getLimit()

}