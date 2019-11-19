package com.example.mynews.common.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mynews.common.di.injector.Injector
import com.example.mynews.common.navigation.Navigator
import com.example.mynews.common.di.injector.InjectorProvider
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(){

    @Inject
    protected lateinit var navigator: Navigator

    private val injector: Injector
        get() = (applicationContext as InjectorProvider).injector

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.getAppComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        navigator.attachActivity(this)
    }

    override fun onStop() {
        navigator.detachActivity(this)
        super.onStop()
    }
}