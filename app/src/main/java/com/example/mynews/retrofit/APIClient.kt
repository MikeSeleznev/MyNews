package com.example.root.mymvvp.retrofit

import com.example.root.mymvvp.utility.ApisUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 class APIClient {

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {

        var okHttpClient: OkHttpClient =  OkHttpClient.Builder().build()


        retrofit = Retrofit.Builder()
                .baseUrl(ApisUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()



        return retrofit!!
    }


}