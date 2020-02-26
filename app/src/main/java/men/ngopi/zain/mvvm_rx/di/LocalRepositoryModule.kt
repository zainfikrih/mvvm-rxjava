package men.ngopi.zain.mvvm_rx.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import men.ngopi.zain.mvvm_rx.data.source.local.LocalRepository
import men.ngopi.zain.mvvm_rx.data.source.local.room.AppDatabase
import javax.inject.Singleton

@Module
class LocalRepositoryModule {
    @Singleton
    @Provides
    fun providesAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java,
            "database-mvvm-rx"
        ).build()
    }

    @Singleton
    @Provides
    fun providesLocalRepository(appDatabase: AppDatabase): LocalRepository {
        return LocalRepository(appDatabase)
    }
}