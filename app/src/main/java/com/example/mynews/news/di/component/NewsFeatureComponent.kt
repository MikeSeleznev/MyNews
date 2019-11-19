package com.example.mynews.news.di.component

import com.example.mynews.news.di.module.NewsFeatureModel
import com.wolo.a222.feature.common.di.Scope.PerFeature
import dagger.Subcomponent

@Subcomponent(modules = [NewsFeatureModel::class])
@PerFeature
interface NewsFeatureComponent{


}