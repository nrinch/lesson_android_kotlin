package na.severinchik.lesson7.data.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import na.severinchik.lesson7.data.entity.Alcohol

@Database(entities = [Alcohol::class], version = 1)
abstract class AlcoholDB : RoomDatabase() {

    abstract fun alcoholDao(): AlcoholDao

    companion object{
        const val DATABASE_NAME = "AlchoDB"
    }
}

object InstanceAlcoDB {
    fun get(application: Application) = Room.databaseBuilder(
        application.applicationContext, AlcoholDB::class.java, "AlchoDB"
    ).build()
}