package com.example.mynews.common.view

import android.os.Bundle
import android.os.PersistableBundle
import com.example.mynews.R

class MainActivity : BaseActivity() {

    companion object {
        fun newInstance() = MainActivity()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            navigator.onStartMainActivity()
        }
    }

    /*lateinit var binding: ActivityMainBinding
    var presenter: MainActivityPresenter? = null
    lateinit var listOfNews: ArrayList<News>
    lateinit var newsAdapter: AdapterNews
    lateinit var recyclerNews: RecyclerView
    var count: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        presenter = MainActivityPresenter(this)

        listOfNews = arrayListOf()
        if (savedInstanceState !=null)
        listOfNews = savedInstanceState.getSerializable(ApisUrl.ARTICLES) as ArrayList<News>

        initData()
    }

    private fun initData() {

        recyclerNews = binding.listNews
        newsAdapter = AdapterNews(presenter, listOfNews, recyclerNews, count, this)


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
*/
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        //outState!!.putSerializable(ApisUrl.ARTICLES, listOfNews)
    }
}



