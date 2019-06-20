package com.example.mynews.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.mynews.Model.News

class AdapterNews(var context: Context, listOfNews: ArrayList<News.ArticlesImage>): RecyclerView.Adapter<AdapterNews.ViewHolder> {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdapterNews.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: AdapterNews.ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(var binding: NewsListItemBinding) : RecyclerView.ViewHolder(binding.root) {}
}