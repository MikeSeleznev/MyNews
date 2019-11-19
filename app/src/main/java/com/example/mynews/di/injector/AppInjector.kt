package com.example.mynews.di.injector

import android.content.Context
import com.example.mynews.di.component.AppComponent
import com.example.mynews.di.component.DaggerAppComponent
import com.example.mynews.di.module.AppModule

class AppInjector(context: Context): Injector {

    override fun getAppComponent() = appComponent

    private val appComponent: AppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(context))
            .build()

}