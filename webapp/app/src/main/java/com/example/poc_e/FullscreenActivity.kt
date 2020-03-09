package com.example.poc_e

import android.app.Activity
import android.os.Bundle
import android.view.KeyEvent
import android.view.Window
import android.webkit.WebView
import android.webkit.WebViewClient


class FullscreenActivity : Activity() {
    private var mWebView: WebView? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        mWebView = WebView(this)
        mWebView!!.loadUrl("https://tmoynat.fr/")
        mWebView!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String
            ): Boolean {
                view.loadUrl(url)
                return true
            }
        }
        this.setContentView(mWebView)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView!!.canGoBack()) {
            mWebView!!.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
