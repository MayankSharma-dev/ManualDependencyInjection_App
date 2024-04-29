package com.ms.manualdependencyinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ms.manualdependencyinjection.presentation.MainViewModel
import com.ms.manualdependencyinjection.presentation.getViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: MainViewModel by viewModels {
            getViewModelFactory(fun(): MainViewModel {
                return MainViewModel(MyApp.appModule.AuthRepository)
            })
        }
        // or
        val viewModel1: MainViewModel by viewModels { MainViewModel.Factory }

        viewModel.login()
        viewModel1.login()
    }
}