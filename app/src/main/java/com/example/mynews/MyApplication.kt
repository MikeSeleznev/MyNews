package com.example.mynews

import android.app.Application
import android.content.Context
import com.example.mynews.retrofit.RetrofitSingleton

class MyApplication: Application() {

    lateinit var context: Context

    @Override
    override fun onCreate() {
        super.onCreate()
        context = this@MyApplication
        RetrofitSingleton.init(1, context)
    }
}