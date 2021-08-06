package com.example.practice.signup

import android.app.Application
import androidx.lifecycle.MutableLiveData


class SignupVIewModel(app: Application):BaseViewModel(app) {
    val email = MutableLiveData("")
    val name = MutableLiveData("")
    val password = MutableLiveData("")

}