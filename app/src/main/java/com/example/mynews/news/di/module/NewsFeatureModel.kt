package com.example.mynews.news.di.module

import com.example.mynews.news.model.interactor.NewsInteractor
import com.example.mynews.news.model.interactor.NewsInteractorImpl
import com.wolo.a222.feature.common.di.Scope.PerFeature
import dagger.Module
import dagger.Provides

@Module
class NewsFeatureModel{

    @Provides
    @PerFeature
    fun bindNewsInteractor(Interactor: NewsInteractorImpl): NewsInteractor = Interactor
}