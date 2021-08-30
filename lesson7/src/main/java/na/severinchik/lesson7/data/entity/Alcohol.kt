package na.severinchik.lesson7.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alcohol")
data class Alcohol(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "power")
    val power: Int,
    @ColumnInfo(name = "halflife")
    val halfLife: Int
){
    @PrimaryKey(autoGenerate = true)
    var uid:Int = 0
}
