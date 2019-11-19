package com.example.mynews

import android.app.Application
import com.example.mynews.common.di.injector.AppInjector
import com.example.mynews.common.di.injector.Injector
import com.example.mynews.common.di.injector.InjectorProvider

class MyNewsApp: Application(), InjectorProvider {

    override lateinit var injector: Injector

    @Override
    override fun onCreate() {
        super.onCreate()
        injector = AppInjector(this)
        injector.getAppComponent().inject(this)
    }
}