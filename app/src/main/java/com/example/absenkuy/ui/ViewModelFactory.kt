package com.example.absenkuy.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.absenkuy.data.local.UserPreferences
import com.example.absenkuy.ui.absen.AbsenViewModel
import com.example.absenkuy.ui.home.HomeViewModel
import com.example.absenkuy.ui.login.LoginViewModel


class ViewModelFactory(private val userPreferences: UserPreferences) : ViewModelProvider
.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(userPreferences) as T
            }
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(userPreferences) as T
            }
            modelClass.isAssignableFrom(AbsenViewModel::class.java) -> {
                AbsenViewModel(userPreferences) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}