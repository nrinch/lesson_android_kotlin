package na.severinchik.lesson7.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import na.severinchik.lesson7.presentation.data.AlcoholItem

@Entity(tableName = "alcohol")
data class Alcohol(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "power")
    val power: Int,
    @ColumnInfo(name = "halflife")
    val halfLife: Int
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}


fun Alcohol.toAlcoholItem(): AlcoholItem = AlcoholItem(
    id = this.uid,
    name = this.name,
    power = this.power,
    halfLife = this.halfLife
)

