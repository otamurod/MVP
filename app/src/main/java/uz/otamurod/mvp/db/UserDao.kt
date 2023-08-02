package uz.otamurod.mvp.db

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun addUser(userEntity: UserEntity)

    @Query("SELECT * FROM UserEntity")
    fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM UserEntity where id=:id")
    fun getUserById(id: Int): UserEntity

    @Update
    fun updateUser(userEntity: UserEntity)

    @Delete
    fun deleteUser(userEntity: UserEntity)
}