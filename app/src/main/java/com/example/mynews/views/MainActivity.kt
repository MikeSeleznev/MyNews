package com.example.mynews.views

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.mynews.R
import com.example.mynews.adapter.AdapterNews
import com.example.mynews.databinding.ActivityMainBinding
import com.example.mynews.model.News
import com.example.mynews.presenter.MainActivityPresenter
import com.example.root.mymvvp.utility.ApisUrl



class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var context: Context
    var presenter: MainActivityPresenter? = null
    lateinit var listOfNews: ArrayList<News>
    lateinit var newsAdapter: AdapterNews
    lateinit var recyclerNews: RecyclerView
    var count: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        context = this@MainActivity
        presenter = MainActivityPresenter(context)

        listOfNews = arrayListOf()
        if (savedInstanceState !=null)
        listOfNews = savedInstanceState!!.getSerializable(ApisUrl.ARTICLES) as ArrayList<News>

        initData()


    }

    private fun initData() {

        recyclerNews = binding.listNews
        newsAdapter = AdapterNews(presenter, listOfNews, recyclerNews, count, context)


        recyclerNews.layoutManager = LinearLayoutManager(context)
        recyclerNews.adapter = newsAdapter

        recyclerNews.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            var previousTotal = 0
            var loading = true
            val visibleThreshold = 3
            var firstVisibleItem = 0
            var visibleItemCount = 0
            var totalItemCount = 0

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                totalItemCount = recyclerNews.layoutManager!!.itemCount
                visibleItemCount = recyclerView.childCount
                totalItemCount = recyclerNews.layoutManager!!.itemCount
                firstVisibleItem = (recyclerNews.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                if (loading) {
                    if (totalItemCount > previousTotal) {
                        loading = false
                        previousTotal = totalItemCount
                    }
                }

                if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
                    count += 1
                    presenter!!.getListNews(recyclerNews, listOfNews, count)
                    loading = true
                }
            }

        })

        if (listOfNews.size > 0){
            newsAdapter.notifyDataSetChanged()
        } else
        presenter!!.getListNews(recyclerNews, listOfNews, count)

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putSerializable(ApisUrl.ARTICLES, listOfNews)
    }

}



