package na.severinchik.lesson7.domain

import kotlinx.coroutines.flow.map
import na.severinchik.lesson7.data.entity.Alcohol
import na.severinchik.lesson7.data.entity.toAlcoholItem
import na.severinchik.lesson7.data.repositories.AlcoRepositories

class AlcoholUseCaseImpl(private val repositories: AlcoRepositories) {

    fun fetchData() =
        repositories.getAll().map { list ->
            list.map { it.toAlcoholItem() }
        }

    suspend fun insert(alcohol: Alcohol) {
        repositories.insert(alcohol)
    }

}