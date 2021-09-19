package na.severinchik.lesson7.data.repositories

import na.severinchik.lesson7.data.storage.UserStorage

private const val DEFAULT_STATE = 0

class UserStateRepository(private val storage: UserStorage) {

    fun getState(): Int = storage.getCurrentState()

    fun updateState(state: Int) {
        val current = storage.getCurrentState()
        storage.updateCurrentState(currentState = current + state)
    }

    fun resetState() {
        storage.updateCurrentState(DEFAULT_STATE)
    }
}