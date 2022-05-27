package com.sollwar.testcalc.app

import android.app.Application
import com.sollwar.testcalc.data.UserRepository

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        UserRepository.initialize(context = applicationContext)
    }

}