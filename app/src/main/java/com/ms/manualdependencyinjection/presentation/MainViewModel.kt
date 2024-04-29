package com.ms.manualdependencyinjection.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.ms.manualdependencyinjection.MyApp
import com.ms.manualdependencyinjection.domain.AuthRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val authRepository: AuthRepository
): ViewModel() {

    // Define ViewModel factory in a companion object
    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>
            ): T {
                return MainViewModel(
                    MyApp.appModule.AuthRepository
                ) as T
            }
        }
    }



        fun login() {
        viewModelScope.launch {
            authRepository.login("test@test.com", "test123")
        }
    }

}