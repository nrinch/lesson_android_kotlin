package na.severinchik.lesson13.data.localstorage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import na.severinchik.lesson13.R
import na.severinchik.lesson13.data.localstorage.dao.DaoCategory
import na.severinchik.lesson13.data.localstorage.dao.DaoNote
import na.severinchik.lesson13.data.localstorage.dto.CategoryDto
import na.severinchik.lesson13.data.localstorage.dto.NoteDto
import java.util.*

const val DB_NAME = "app_db"

@Database(entities = [NoteDto::class, CategoryDto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun daoCategory(): DaoCategory
    abstract fun daoNote(): DaoNote

    companion object {
        private var INSTANCE: AppDatabase? = null

        private fun createInstance(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            DB_NAME
        )
            .addCallback(object : Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    runBlocking {
                        with(Dispatchers.IO) {
                            getInstance(context).daoCategory().saveAll(CATEGORIES(context))
                            getInstance(context).daoNote().saveAll(NOTES)
                        }
                    }
                }
            })
            .build()

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = createInstance(context)
                }
                return INSTANCE!!
            }
        }
    }
}


private val NOTES: List<NoteDto> = listOf<NoteDto>(
    NoteDto(
        "Sample Tittle",
        "This note a created for a example",
        Calendar.getInstance().timeInMillis, 1
    ),
    NoteDto(
        "Toss a coin",
        "Toss a coin to your Witcher O’ Valley of Plenty".trimIndent(),
        Calendar.getInstance().timeInMillis, 2
    )
)

private fun CATEGORIES(context: Context): List<CategoryDto> {
    return listOf(
        CategoryDto("Work", context.resources.getColor(R.color.catClrRed), 0),
        CategoryDto("Home", context.resources.getColor(R.color.catClrPink), 1)
    )
}