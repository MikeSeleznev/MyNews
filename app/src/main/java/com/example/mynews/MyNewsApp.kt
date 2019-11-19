package com.example.mynews

import android.app.Application
import android.content.Context
import com.example.mynews.di.component.AppComponent
import com.example.mynews.di.component.DaggerAppComponent
import com.example.mynews.di.module.AppModule
import com.example.mynews.retrofit.RetrofitSingleton

class MyNewsApp: Application() {

    internal lateinit var appComponent: AppComponent

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        appComponent = buildComponent(base!!)
    }

    @Override
    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        RetrofitSingleton.init(1, this)
    }

    private fun buildComponent(context: Context): AppComponent {
        return DaggerAppComponent.builder()
            .appModule(AppModule(context))
            .build()
    }
}