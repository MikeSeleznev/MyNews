package com.example.mynews.news.view

import android.os.Bundle
import android.view.View
import com.example.mynews.R
import com.example.mynews.common.view.PresenterFragment
import com.example.mynews.news.presenter.NewsPresenter
import com.example.mynews.news.presenter.NewsState
import com.example.mynews.news.presenter.NewsView
import io.reactivex.android.schedulers.AndroidSchedulers


import javax.inject.Inject

class NewsFragment : PresenterFragment<NewsPresenter>(), NewsView {

    companion object {
        fun newInstance() = NewsFragment()
    }

    @Inject
    override lateinit var presenter: NewsPresenter

    override val layoutResId: Int
        get() = R.layout.fragment_news


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.viewState()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleState)
            .run { disposeOnDestroyView(this) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       
    }

    private fun handleState(state: NewsState) {

    }
}