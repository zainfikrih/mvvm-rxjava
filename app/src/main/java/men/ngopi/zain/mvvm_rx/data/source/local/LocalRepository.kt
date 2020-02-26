package men.ngopi.zain.mvvm_rx.data.source.local

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import io.reactivex.Flowable
import io.reactivex.Single
import men.ngopi.zain.mvvm_rx.data.source.local.entity.User
import men.ngopi.zain.mvvm_rx.data.source.local.room.AppDatabase

class LocalRepository(appDatabase: AppDatabase) {

    private val userDao = appDatabase.userDao()

    companion object {
        private lateinit var instance: LocalRepository
        private lateinit var appDatabase: RoomDatabase

        fun getInstance(application: Application): LocalRepository {
            if (instance == null) {
                instance = LocalRepository(
                    Room.databaseBuilder(
                        application.applicationContext,
                        AppDatabase::class.java,
                        "database-mvvm-rx"
                    ).build()
                )
            }
            return instance
        }
    }

    fun insertUser(user: User): Single<Long> {
        return userDao.insert(user)
    }

    fun getAllUser(): Flowable<List<User>> {
        return userDao.getAll()
    }
}