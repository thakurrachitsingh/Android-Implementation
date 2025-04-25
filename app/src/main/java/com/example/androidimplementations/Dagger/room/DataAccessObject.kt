package com.example.androidimplementations.Dagger.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface DataAccessObject {

    @Insert
    fun insertUser(user: UserEntity)

    @Update
    fun updateUser(user: UserEntity)

    @Query("SELECT * FROM user_table")
    fun getUsers()

    @Query("SELECT * FROM user_table WHERE id = :id")
    fun getUserById(id: Int): LiveData<List<UserEntity>>

    @Delete
    fun deleteUser(user: UserEntity)
}