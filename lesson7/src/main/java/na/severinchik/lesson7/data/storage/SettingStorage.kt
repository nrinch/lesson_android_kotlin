package na.severinchik.lesson7.data.storage

import android.app.Application
import android.content.Context

const val DEFAULT_SHARED_PREFERENCES = "default_settings"

class SettingStorage(application: Application) {

    private val sharedPreferences = application.getSharedPreferences(
        DEFAULT_SHARED_PREFERENCES,
        Context.MODE_PRIVATE
    )

    private val editor = sharedPreferences.edit()


    fun updateLimit(limit: Int) {
        editor.putInt(LIMIT, limit)
        editor.apply()
    }

    fun getLimit(): Int = sharedPreferences.getInt(LIMIT, LIMIT_DEFAULT)

    fun delete(){
        editor.remove(LIMIT)
    }

    private companion object {
        const val LIMIT = "limit"
        const val LIMIT_DEFAULT = 0


    }
}