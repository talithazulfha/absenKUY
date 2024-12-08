package com.example.absenkuy.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.absenkuy.data.local.UserPreferences
import kotlinx.coroutines.launch

class HomeViewModel(private val userPreferences: UserPreferences) : ViewModel() {

    fun logout() {
        viewModelScope.launch {
            userPreferences.logout()
        }
    }
}