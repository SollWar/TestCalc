package com.sollwar.testcalc.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sollwar.testcalc.data.model.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}