package na.severinchik.lesson13.data.localstorage.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import na.severinchik.lesson13.data.localstorage.dto.CategoryDto

@Dao
interface DaoCategory {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(categories: List<CategoryDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: CategoryDto)

    @Update
    suspend fun update(category: CategoryDto)

    @Delete
    suspend fun delete(category: CategoryDto)

    @Query("DELETE FROM Category")
    suspend fun deleteAll()

    @Query("SELECT * FROM Category")
    fun getAll(): Flow<List<CategoryDto>>

    @Query("SELECT * FROM Category LIMIT 1")
    suspend fun getDefaultCategory(): CategoryDto

    @Query("SELECT * FROM Category WHERE id=:id")
    suspend fun getById(id: Long): CategoryDto
}