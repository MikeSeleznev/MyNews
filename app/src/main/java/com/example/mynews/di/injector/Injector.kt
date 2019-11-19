package com.example.mynews.di.injector

import com.example.mynews.di.component.AppComponent

interface Injector {

    fun getAppComponent(): AppComponent
}