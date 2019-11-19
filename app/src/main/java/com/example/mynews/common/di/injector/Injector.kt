package com.example.mynews.common.di.injector

import com.example.mynews.common.di.component.AppComponent

interface Injector {

    fun getAppComponent(): AppComponent
}