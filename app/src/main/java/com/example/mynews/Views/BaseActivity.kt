package com.example.mynews.views

import android.support.v7.app.AppCompatActivity
import com.example.mynews.MyNewsApp

abstract class BaseActivity : AppCompatActivity(){
    val appComponent
        get() = (application as MyNewsApp).appComponent
}