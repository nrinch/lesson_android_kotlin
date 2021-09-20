package na.severinchik.lesson13.data.localstorage.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import na.severinchik.lesson13.data.localstorage.dto.NoteDto

@Dao
interface DaoNote {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(notes: List<NoteDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: NoteDto)

    @Update
    suspend fun update(note: NoteDto)

    @Delete
    suspend fun delete(note: NoteDto)

    @Query("DELETE FROM note WHERE id=:id")
    suspend fun deleteByID(id: Long)

    @Query("DELETE FROM note")
    suspend fun deleteAll()

    @Query("DELETE FROM note WHERE idCaterogy=:idCategory")
    suspend fun deleteAllByCategory(idCategory: Long)

    @Query("SELECT * FROM note ORDER BY note.timoOfCreation DESC ")
    fun getAllNotes(): Flow<List<NoteDto>>

    @Query("SELECT * FROM note WHERE idCaterogy=:id")
    fun getCategoryNotes(id: Long): Flow<List<NoteDto>>

    @Query("SELECT * FROM note WHERE id =:id")
    suspend fun getById(id: Long): NoteDto
}