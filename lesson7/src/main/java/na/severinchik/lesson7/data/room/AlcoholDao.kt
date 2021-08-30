package na.severinchik.lesson7.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import na.severinchik.lesson7.data.entity.Alcohol

@Dao
interface AlcoholDao {
    @Insert
    suspend fun insert(item: Alcohol)

    @Update
    suspend fun update(item: Alcohol)

    @Query("Select * from ALCOHOL")
    fun getAll(): Flow<List<Alcohol>>

    @Query("Select * from ALCOHOL where uid LIKE :id")
    fun getById(id: Int): Alcohol


}