package na.severinchik.lesson7.data.repositories

import kotlinx.coroutines.flow.Flow
import na.severinchik.lesson7.data.entity.Alcohol

interface BaseEntityRepository<T> {

    suspend fun insert(item: T)

    suspend fun update(item: T)

    fun getAll(): Flow<List<Alcohol>>

    fun getFirstById(id: Int):T
}