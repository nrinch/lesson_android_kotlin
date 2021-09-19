package na.severinchik.lesson7.domain

import kotlinx.coroutines.flow.map
import na.severinchik.lesson7.data.entity.Alcohol
import na.severinchik.lesson7.data.entity.toAlcoholItem
import na.severinchik.lesson7.data.repositories.AlcoRepositories
import na.severinchik.lesson7.data.repositories.UserStateRepository

private val MAGIC_ALCOHOL_COF = 2

class AlcoholUseCaseImpl(
    private val alcoRepositories: AlcoRepositories,
    private val userStateRepository: UserStateRepository
) {

    fun fetchData() =
        alcoRepositories.getAll().map { list ->
            list.map { it.toAlcoholItem() }
        }

    suspend fun insert(alcohol: Alcohol) {
        alcoRepositories.insert(alcohol)
    }

   suspend fun updateStateUser(idAlcohol: Int) {
        val currentAlcohol = alcoRepositories.getFirstById(idAlcohol)
        userStateRepository.updateState(
            generateValueForUpdateStateUser(currentAlcohol)
        )
    }

    fun getUserState() = userStateRepository.getState()

    fun resetState() = userStateRepository.resetState()

    private fun generateValueForUpdateStateUser(alcohol: Alcohol): Int {
        return alcohol.power * MAGIC_ALCOHOL_COF
    }
}