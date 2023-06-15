package com.adhibuchori.temendaki.ui.auth.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adhibuchori.temendaki.databinding.ActivityWelcomeBinding
import com.adhibuchori.temendaki.ui.auth.login.LoginActivity
import com.adhibuchori.temendaki.ui.auth.signup.SignupActivity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpAction()
    }

    private fun setUpAction() {
        binding.apply {
            btnLogin.setOnClickListener {
                val moveToLogin = Intent(this@WelcomeActivity, LoginActivity::class.java)
                startActivity(moveToLogin)
            }
            btnSignup.setOnClickListener {
                val moveToSignup = Intent(this@WelcomeActivity, SignupActivity::class.java)
                startActivity(moveToSignup)
            }
        }
    }
}