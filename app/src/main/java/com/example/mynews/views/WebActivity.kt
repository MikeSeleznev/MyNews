package com.example.mynews.views

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mynews.R
import com.example.mynews.databinding.ActivityWebBinding
import java.io.Serializable

class WebActivity : AppCompatActivity() {

    lateinit var binding: ActivityWebBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_web)
        binding.webView.loadUrl(intent.getStringExtra("url"))

    }
}
