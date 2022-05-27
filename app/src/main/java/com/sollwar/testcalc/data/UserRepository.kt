package com.sollwar.testcalc.data

import android.content.Context
import androidx.room.Room
import com.sollwar.testcalc.data.model.AuthUser
import com.sollwar.testcalc.data.model.User
import com.sollwar.testcalc.data.room.UserDatabase
import kotlinx.coroutines.delay

private const val DATABASE_NAME = "user_database"

class UserRepository private constructor(context: Context){

    private val database: UserDatabase = Room.databaseBuilder(
        context,
        UserDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()

    private val dao = database.userDao()

    fun addUser(user: User) = dao.addUser(user)
    suspend fun signIn(login: String, password: String): AuthUser {
        delay(1000) // Как-будто думает
        return dao.signIn(login, password)
    }

    companion object {
        private var instance: UserRepository? = null
        fun initialize(context: Context) {
            if (instance == null) {
                instance = UserRepository(context)
            }
        }

        fun get(): UserRepository {
            return instance ?: throw IllegalStateException("RoomRepository должен быть проинициализирован")
        }
    }
}