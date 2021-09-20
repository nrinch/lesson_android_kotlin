package na.severinchik.lesson13.data.localstorage.dto

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Entity(tableName = "note")
data class NoteDto(
    val title: String,
    val information: String,
    val timoOfCreation: Long,
    val idCaterogy: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
}