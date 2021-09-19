package na.severinchik.lesson7.data.storage

import android.app.Application
import android.content.Context

class UserStorage(private val application: Application) {

    private val sharedPreferences = application.getSharedPreferences(
        DEFAULT_SHARED_PREFERENCES,
        Context.MODE_PRIVATE
    )

    private val editor = sharedPreferences.edit()


    fun updateCurrentState(currentState: Int) {
        editor.putInt(CURRENT_STATE, currentState)
        editor.apply()
    }

    fun getCurrentState(): Int = sharedPreferences.getInt(CURRENT_STATE, CURRENT_STATE_DEFAULT)

    fun delete(){
        editor.remove(CURRENT_STATE)
    }

    private companion object {
        const val CURRENT_STATE = "current_state"
        const val CURRENT_STATE_DEFAULT = 0


    }

}