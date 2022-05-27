package com.sollwar.testcalc.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sollwar.testcalc.data.model.AuthUser
import com.sollwar.testcalc.data.model.User

@Dao
interface UserDao {
    @Insert
    fun addUser(user: User)

    @Query("SELECT userId, userName FROM User WHERE userName = :login and userPassword = :password")
    suspend fun signIn(login: String, password: String): AuthUser
}