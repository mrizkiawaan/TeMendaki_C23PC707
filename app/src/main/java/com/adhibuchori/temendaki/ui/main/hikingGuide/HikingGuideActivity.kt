package com.adhibuchori.temendaki.ui.main.hikingGuide

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.adhibuchori.temendaki.R
import com.adhibuchori.temendaki.databinding.ActivityHikingGuideBinding

class HikingGuideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHikingGuideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHikingGuideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadHikingGuide()
    }

    private fun loadHikingGuide() {

        binding.apply {
            @SuppressLint("SetJavaScriptEnabled")
            wvHikingGuide.settings.javaScriptEnabled = true
            wvHikingGuide.webViewClient = WebViewClient()

            wvHikingGuide.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView, url: String) {
                    Toast.makeText(
                        this@HikingGuideActivity,
                        "Web Berhasil Dimuat",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            wvHikingGuide.loadUrl("https://napaktilas.net/panduan-pendaki-pemula/")
        }
    }
}