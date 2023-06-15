package com.adhibuchori.temendaki.ui.auth.splash

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.adhibuchori.temendaki.databinding.ActivitySplashscreenBinding
import com.adhibuchori.temendaki.ui.auth.AuthViewModel
import com.adhibuchori.temendaki.ui.auth.AuthViewModelFactory
import com.adhibuchori.temendaki.ui.auth.welcome.WelcomeActivity
import com.adhibuchori.temendaki.ui.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashscreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashscreenBinding

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth")

    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModelFactory.getInstance(dataStore)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        isLogin()
    }

    private fun isLogin() {
        authViewModel.isLogin().observe(this) {
            if (!it.isNullOrEmpty()) {
                startActivity(Intent(this@SplashscreenActivity, MainActivity::class.java))
                finish()
            } else {
                @Suppress("DEPRECATION")
                Handler().postDelayed({
                    val intent = Intent(this@SplashscreenActivity, WelcomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }, SPLASH_DELAY)
            }
        }
    }

    companion object {
        private const val SPLASH_DELAY = 2000L
    }
}