package com.example.mynews.Views

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mynews.Model.News
import com.example.mynews.Presenter.MainActivityPresenter
import com.example.mynews.R
import com.example.mynews.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var context: Context
    var presenter: MainActivityPresenter? = null
    lateinit var listOfNews: ArrayList<News.ArticlesImage>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        context = this@MainActivity

        initData()
    }

    private fun initData() {

        listOfNews = arrayListOf()
        newsAdapter = AdapterNews(context, listOfNews)

    }
}
