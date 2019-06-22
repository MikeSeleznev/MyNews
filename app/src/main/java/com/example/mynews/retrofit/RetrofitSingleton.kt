package com.example.mynews.retrofit

import android.content.Context
import com.example.mynews.model.News
import com.example.root.mymvvp.utility.ApisUrl
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.schedulers.Schedulers
import rx.subjects.BehaviorSubject


class RetrofitSingleton {

    companion object {
        lateinit var observableRetrofit: Observable<News>
        lateinit var observableNewsList: BehaviorSubject<News>
        lateinit var subscription: Subscription
        lateinit var apiService: APIInterface

        fun init(count: Int, context: Context) {

            var rxAdapter = RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io())
            var gson = GsonBuilder().create()

            var okHttpClient: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(Interceptors.Companion.OfflineCacheInterceptor(context))
                .addNetworkInterceptor(Interceptors.Companion.NetworkCacheInterceptor(context))
                .cache(Interceptors.provideCache(context))
                .build()

            var retrofit = Retrofit.Builder()
                .baseUrl(ApisUrl.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxAdapter)
                .build()

            apiService = retrofit.create(APIInterface::class.java)

            observableRetrofit = apiService.getNews(ApisUrl.SOURCE, ApisUrl.API_KEY, count)

        }


        fun resetNewsObservable(){
            observableNewsList = BehaviorSubject.create()
            subscription = observableRetrofit.subscribe(object : Subscriber<News>() {
                override fun onNext(t: News?) {
                    observableNewsList.onNext(t)
                }

                override fun onCompleted() {

                }

                override fun onError(e: Throwable?) {

                }


            })


        }

        fun getNewsObservable(count: Int): Observable<News> {
            observableRetrofit = apiService.getNews(ApisUrl.SOURCE, ApisUrl.API_KEY, count)
            resetNewsObservable()
            return observableNewsList
        }
    }
}

