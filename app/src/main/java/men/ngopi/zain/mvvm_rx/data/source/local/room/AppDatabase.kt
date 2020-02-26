package men.ngopi.zain.mvvm_rx.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import men.ngopi.zain.mvvm_rx.data.source.local.entity.User

// Prod: exportSchema = true

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}