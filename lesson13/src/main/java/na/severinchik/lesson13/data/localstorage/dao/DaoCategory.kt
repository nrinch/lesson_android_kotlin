package na.severinchik.lesson13.data.localstorage.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import na.severinchik.lesson13.data.localstorage.dto.CategoryDto

@Dao
interface DaoCategory {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(categories: List<CategoryDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: CategoryDto)

    @Update
    fun update(category: CategoryDto)

    @Delete
    fun delete(category: CategoryDto)

    @Query("DELETE FROM Category")
    fun deleteAll()

    @Query("SELECT * FROM Category")
    fun findAll(): Flow<List<CategoryDto>>

    @Query("SELECT * FROM Category")
    fun getAll(): List<CategoryDto>

    @Query("SELECT * FROM Category LIMIT 1")
    fun getDefaultCategory(): CategoryDto

    @Query("SELECT * FROM Category WHERE id=:id")
    fun getById(id: Long): CategoryDto
}