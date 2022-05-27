package com.sollwar.testcalc.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Int = -1,
    val userName: String = "",
    val userPassword: String = ""
)
