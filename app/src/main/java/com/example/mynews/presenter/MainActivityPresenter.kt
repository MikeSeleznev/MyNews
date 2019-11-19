package com.example.mynews.presenter

import android.content.Context
import android.support.v7.widget.RecyclerView
import com.example.mynews.model.News
import com.example.mynews.retrofit.RetrofitSingleton

import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class MainActivityPresenter @Inject constructor(private val context: Context) {

    fun getListNews(recyclerNews: RecyclerView, listOfNews:  ArrayList<News>, count: Int){

        var subscription = RetrofitSingleton.getNewsObservable(count)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<News>(){
                override fun onNext(t: News?) {
                    t!!.articles?.let { listOfNews.addAll(it)
                    }
                    recyclerNews.adapter!!.notifyDataSetChanged()
                }

                override fun onCompleted() {

                }

                override fun onError(e: Throwable?) {

                }

            })
    }
}