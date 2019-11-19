package com.example.mynews.di.module

import android.content.Context
import com.example.mynews.presenter.MainActivityPresenter
import com.wolo.a222.feature.common.di.Scope.PerApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    @PerApplication
    fun provideContext(): Context = context

    @Provides
    @PerApplication
    internal fun provideMainActivityPresenter(context: Context)  = MainActivityPresenter(context)

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