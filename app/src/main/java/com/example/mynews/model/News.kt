package com.example.mynews.model

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.io.Serializable

open class News: Serializable {

     open class ArticlesImage{

        companion object {
            @BindingAdapter("app:imageUrl")
            @JvmStatic
            fun loadImage(view: ImageView, imageUrl: String) {
                Glide.with(view.context).load(imageUrl).into(view);
            }

        }
    }


    var articles: ArrayList<News>? = null

    var publishedAt: String? = null

    var urlToImage: String? = null

    var url: String? = null

    var description: String? = null

    var title: String? = null

}
