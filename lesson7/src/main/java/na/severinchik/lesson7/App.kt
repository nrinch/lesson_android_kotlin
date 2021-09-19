package na.severinchik.lesson7

import android.app.Application
import androidx.room.Room
import na.severinchik.lesson7.data.repositories.AlcoRepositories
import na.severinchik.lesson7.data.repositories.UserStateRepository
import na.severinchik.lesson7.data.room.AlcoholDB
import na.severinchik.lesson7.data.room.AlcoholDao
import na.severinchik.lesson7.data.storage.UserStorage
import na.severinchik.lesson7.domain.AlcoholUseCaseImpl
import na.severinchik.lesson7.presentation.dialogs.add.AddViewModel
import na.severinchik.lesson7.presentation.dialogs.list.DialogListViewModel
import na.severinchik.lesson7.presentation.fragments.listFragment.ListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                dataModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}

val dataModule = module {

    fun provideDatabase(application: Application): AlcoholDB {
        return Room.databaseBuilder(application, AlcoholDB::class.java, AlcoholDB.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideAlcoholDao(database: AlcoholDB): AlcoholDao {
        return database.alcoholDao()
    }

    single {
        provideDatabase(androidApplication())
    }

    single {
        provideAlcoholDao(database = get())
    }

    single {
        UserStorage(androidApplication())
    }
}

val useCaseModule = module {
    factory {
        AlcoRepositories(dao = get())
    }

    single {
        UserStateRepository(storage = get())
    }

    single() {
        AlcoholUseCaseImpl(
            userStateRepository = get(),
            alcoRepositories = get()
        )
    }
}

val viewModelModule = module {
    viewModel {
        ListViewModel(useCaseImpl = get())
    }
    viewModel {
        AddViewModel(useCaseImpl = get())
    }
    viewModel {
        DialogListViewModel(useCaseImpl = get())
    }
}