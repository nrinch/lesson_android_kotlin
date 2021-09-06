package na.severinchik.lesson7.presentation.data

import androidx.room.ColumnInfo
import na.severinchik.lesson7.data.entity.BasicUiEntity

data class AlcoholItem(
    val id: Int,
    val name: String,
    val power: Int,
    val halfLife: Int
) : BasicUiEntity<AlcoholItem>() {
    override fun same(entity: BasicUiEntity<AlcoholItem>): Boolean {
        return entity is AlcoholItem && id == entity.id
    }

    override fun contentSame(entity: BasicUiEntity<AlcoholItem>): Boolean {
        return entity is AlcoholItem && this == entity
    }
}


