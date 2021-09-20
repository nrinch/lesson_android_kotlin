package na.severinchik.lesson13.data.localstorage.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class CategoryDto(
    val name: String,
    val color: Int,
    val positionColor: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
}