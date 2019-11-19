package com.example.mynews.common.di.module

import android.content.Context
import com.example.mynews.common.di.scope.PerApplication
import com.example.mynews.common.navigation.Navigator
import com.example.mynews.common.navigation.NavigatorImpl
import com.example.mynews.common.presenter.MainActivityPresenter
import com.example.mynews.common.presenter.MainActivityPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    @PerApplication
    fun provideContext(): Context = context

    @Provides
    @PerApplication
    fun provideNavigator(navigator: NavigatorImpl): Navigator = navigator

    @Provides
    @PerApplication
    fun provideMainActivityPresenter(presenter: MainActivityPresenterImpl): MainActivityPresenter = presenter


    /*@Provides
    @PerApplication
    fun provideRetrofit(context: Context){
        return retrofit = Retrofit.Builder()
            .baseUrl(ApisUrl.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(rxAdapter)
            .build()
    }*/

}