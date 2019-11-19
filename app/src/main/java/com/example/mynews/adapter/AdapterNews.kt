package com.example.mynews.adapter

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mynews.model.News
import com.example.mynews.R
import com.example.mynews.Utils
import com.example.mynews.databinding.NewsListBinding
import com.example.mynews.presenter.MainActivityPresenter
import com.example.mynews.views.WebActivity


class AdapterNews(var listOfNews: ArrayList<News>, var recyclerNews: RecyclerView, var count: Int, var context: Context): RecyclerView.Adapter<AdapterNews.ViewHolder>() {

    var layoutInflater: LayoutInflater? = null


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdapterNews.ViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(p0.context)
        }
        var binding: NewsListBinding = DataBindingUtil.inflate(this!!.layoutInflater!!, R.layout.news_list, p0, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOfNews.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.binding.reload.visibility = View.GONE
        if (p1 == listOfNews.size-1 && !Utils.isNetworkAvailable(context)){
            p0.binding.reload.visibility = View.VISIBLE
            p0.binding.reload.setOnClickListener(View.OnClickListener {
                count += 1
                //presenter!!.getListNews(recyclerNews, listOfNews, count)
            })

        }
       p0.binding.news = listOfNews[p1]
       p0.binding.tvTitle.setOnClickListener(View.OnClickListener {
          val intent = Intent(context, WebActivity::class.java)
           intent.putExtra("url",listOfNews[p1].url)
           context.startActivity(intent)
       })

    }

    class ViewHolder(var binding: NewsListBinding) : RecyclerView.ViewHolder(binding.root)


}