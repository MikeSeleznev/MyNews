package com.example.mynews.Model

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

class News {

    class ArticlesImage{

        companion object {
            @BindingAdapter("bind:imageUrl")
            @JvmStatic
            fun loadImage(view: ImageView, imageUrl: String) {
                Glide.with(view.context).load(imageUrl).into(view);
            }

        }
    }


    var articles: ArrayList<ArticlesImage>? = null

    var totalResults: Int = 0

    var status: String? = null

    var id:Int?=null

    var content: String? = null

    var publishedAt: String? = null


    var urlToImage: String? = null

    var url: String? = null


    var description: String? = null


    var title: String? = null

    var author: String? = null

    var source: SourceBean? = null
}
class SourceBean {

    var name: String? = null

}