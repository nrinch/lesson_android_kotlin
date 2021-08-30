package na.severinchik.lesson7.data.repositories

import kotlinx.coroutines.flow.Flow
import na.severinchik.lesson7.data.entity.Alcohol
import na.severinchik.lesson7.data.room.AlcoholDao

class AlcoRepositories(val dao: AlcoholDao) : BaseEntityRepository<Alcohol> {

    override suspend fun insert(item: Alcohol) {
        dao.insert(item)
    }

    override fun getAll(): Flow<List<Alcohol>> = dao.getAll()

    override fun getFirstById(id: Int): Alcohol = dao.getById(id)

    override suspend fun update(item: Alcohol) {
        dao.update(item)
    }
}