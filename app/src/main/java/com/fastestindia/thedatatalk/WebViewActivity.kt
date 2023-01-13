package com.fastestindia.thedatatalk

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.fastestindia.thedatatalk.R


class WebViewActivity : AppCompatActivity() {
    lateinit var webView:WebView
    lateinit var progressBar:ProgressBar
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        progressBar=findViewById(R.id.progressBar)
        webView=findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()
        val url=intent.getStringExtra("url").toString()
        webView.loadUrl(url)
    }
    inner class WebViewClient : android.webkit.WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return false
        }

        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            progressBar.visibility = View.GONE
        }
    }
}