package na.severinchik.lesson7.presentation.fragments.settingFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import na.severinchik.lesson7.data.storage.SettingStorage

class SettingViewModel(application: Application) : AndroidViewModel(application) {
    private val settingStorage = SettingStorage(application)

    fun getLimit() = settingStorage.getLimit()

    fun saveLimit(limit: Int) {
        settingStorage.updateLimit(limit)
    }
}