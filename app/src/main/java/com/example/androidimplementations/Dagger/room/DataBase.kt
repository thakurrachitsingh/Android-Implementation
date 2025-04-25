package com.example.androidimplementations.Dagger.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [UserEntity::class], version = 1)
abstract class DataBase : RoomDatabase(){

    abstract fun contactDao(): DataAccessObject

}