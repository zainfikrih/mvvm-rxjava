package men.ngopi.zain.mvvm_rx.data.source.local.room

import androidx.room.*
import io.reactivex.Flowable
import io.reactivex.Single
import men.ngopi.zain.mvvm_rx.data.source.local.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity")
    fun getAll(): Flowable<List<User>>

    @Insert
    fun insert(user: User): Single<Long>

    @Insert
    fun insertAll(vararg users: User): Single<List<Long>>

    @Update
    fun update(user: User): Single<Int>

    @Update
    fun updateAll(vararg users: User): Single<Int>

    @Delete
    fun delete(user: User): Single<Int>

    @Delete
    fun deleteAll(vararg users: User): Single<Int>
}