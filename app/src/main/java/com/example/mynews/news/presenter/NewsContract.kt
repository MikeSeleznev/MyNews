package com.example.mynews.news.presenter

import com.example.mynews.common.presenter.BasePresenter
import com.example.mynews.common.presenter.View
import io.reactivex.Flowable

interface NewsPresenter : BasePresenter<NewsView> {

    fun viewState(): Flowable<NewsState>

    fun initState()

}

interface NewsView : View

data class NewsState(
    val loaded: Boolean
)