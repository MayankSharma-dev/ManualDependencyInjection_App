package com.ms.manualdependencyinjection.di

import android.content.Context
import com.ms.manualdependencyinjection.data.AuthApi
import com.ms.manualdependencyinjection.data.AuthRepositoryImpl
import com.ms.manualdependencyinjection.domain.AuthRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

interface AppModule{
    val authApi: AuthApi
    val AuthRepository: AuthRepository
}

class AppModuleImpl(appContext: Context): AppModule{
    override val authApi: AuthApi by lazy {
        Retrofit.Builder()
            .baseUrl("http:my-url.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    override val AuthRepository: AuthRepository by lazy {
        AuthRepositoryImpl(authApi)
    }

}