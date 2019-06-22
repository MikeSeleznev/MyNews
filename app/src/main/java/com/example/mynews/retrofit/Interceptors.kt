package com.example.mynews.retrofit

import android.content.Context
import com.example.mynews.Utils
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.CacheControl
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit



class Interceptors {

    companion object {

        private val MAX_AGE = 120
        private val MAX_STALE: Long = 86400


        class OfflineCacheInterceptor(var context: Context) : Interceptor {

            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                var request = chain.request()

                if (!Utils.isNetworkAvailable(context)) {
                    val cacheControl = CacheControl.Builder()
                        .maxStale(1, TimeUnit.DAYS)
                        .build()
                    request = request.newBuilder()
                        .header("Cache-Control", cacheControl.toString())
                        .build()
                }
                return chain.proceed(request)
            }

        }


        class NetworkCacheInterceptor(var context: Context) : Interceptor {

            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val originalRequest = chain.request()

                val cacheHeaderValue = if (Utils.isNetworkAvailable(context))
                    "public, max-age=$MAX_AGE"
                else
                    "public, only-if-cached, max-stale=$MAX_STALE"
                val request = originalRequest.newBuilder().build()
                val response = chain.proceed(request)
                return response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", cacheHeaderValue)
                    .build()
            }
        }


        fun provideCache(context: Context): Cache? {
            var cache: Cache? = null
            try {
                val dir = context.cacheDir
                cache = Cache(File(dir, "http-cache"), 10 * 1024 * 1024) // 10 MB
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return cache
        }
    }
}