package com.sollwar.testcalc

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sollwar.testcalc.data.Calc
import com.sollwar.testcalc.data.UserRepository
import com.sollwar.testcalc.data.model.AuthUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val userRepository = UserRepository.get()

    val currentUser: MutableLiveData<AuthUser> = MutableLiveData()
    val calc = Calc()

    fun singIn(login: String, password: String) {
        viewModelScope.launch {
            val singInResponse = viewModelScope.async(Dispatchers.IO) {
                return@async userRepository.signIn(login, password)
            }
            currentUser.value = singInResponse.await()
            if (currentUser.value == null) {
                currentUser.value = AuthUser()
            }
        }
    }
}