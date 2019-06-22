package com.example.mynews

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v4.content.ContextCompat.getSystemService

class Utils {

    companion object {

        fun isNetworkAvailable(context: Context): Boolean {
            var connectivity: ConnectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            try {
                val activeNetworkInfo = connectivity.activeNetworkInfo
                if (activeNetworkInfo != null && activeNetworkInfo!!.isConnected) {
                    return true
                }
            } catch (e: Exception) {

            }

            return false
        }
    }
}