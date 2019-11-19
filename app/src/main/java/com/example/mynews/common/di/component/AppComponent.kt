package com.example.mynews.common.di.component

import com.example.mynews.MyNewsApp
import com.example.mynews.common.di.module.AppModule
import com.example.mynews.common.view.BaseActivity
import com.example.mynews.common.di.scope.PerApplication
import com.example.mynews.news.di.component.NewsFeatureComponent
import dagger.Component

@PerApplication
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(application: MyNewsApp)

    fun inject(activity: BaseActivity)

    fun plusNewsFeature(): NewsFeatureComponent
}