package com.example.mynews.common.presenter

import io.reactivex.Flowable


interface MainActivityPresenter: BasePresenter<MainActivityView> {
    fun viewState(): Flowable<MainActivityState>
}

interface MainActivityView: View

data class MainActivityState(
        val closeMenuIsVisible: Boolean,
        val topMenuIsVisible: Boolean
)