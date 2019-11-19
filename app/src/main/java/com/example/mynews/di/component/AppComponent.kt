package com.example.mynews.di.component

import com.example.mynews.MyNewsApp
import com.example.mynews.di.module.AppModule
import com.example.mynews.views.MainActivity
import com.wolo.a222.feature.common.di.Scope.PerApplication
import dagger.Component

@PerApplication
@Component(modules = [AppModule::class])
interface AppComponent{

 fun inject(application: MyNewsApp)

 fun inject(mainActivity: MainActivity)

}