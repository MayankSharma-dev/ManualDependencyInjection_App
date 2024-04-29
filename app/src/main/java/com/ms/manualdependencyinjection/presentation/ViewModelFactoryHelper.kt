package com.ms.manualdependencyinjection.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ms.manualdependencyinjection.domain.AuthRepository

fun <VM: ViewModel> getViewModelFactory(initializer:() -> VM): ViewModelProvider.Factory{
    return object : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return initializer() as T
        }
    }
}
