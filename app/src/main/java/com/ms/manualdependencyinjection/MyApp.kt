package com.ms.manualdependencyinjection

import android.app.Application
import com.ms.manualdependencyinjection.di.AppModule
import com.ms.manualdependencyinjection.di.AppModuleImpl

class MyApp: Application() {

    //Singleton
    companion object{
        lateinit var appModule: AppModule
    }

    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl(this)
    }
}