package com.example.mynews.common.navigation

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity


interface Navigator {

    fun attachActivity(activity: AppCompatActivity)

    fun detachActivity(activity: AppCompatActivity)

    fun onStartMainActivity()

    fun onFinish(fragment: Fragment)

}