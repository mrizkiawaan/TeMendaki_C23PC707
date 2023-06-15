package com.adhibuchori.temendaki.ui.main.profile

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.adhibuchori.temendaki.R
import com.adhibuchori.temendaki.databinding.ActivityProfileBinding
import com.adhibuchori.temendaki.ui.main.MainViewModel
import com.adhibuchori.temendaki.ui.main.MainViewModelFactory
import com.adhibuchori.temendaki.data.remote.utils.Result
import com.adhibuchori.temendaki.ui.auth.welcome.WelcomeActivity

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth")

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory.getInstance(dataStore)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()
        moveToHome()
        logout()
    }

    private fun setToolbar() {
        binding.toolbar.apply {
            ivToolbarIcon.setImageResource(R.drawable.ic_arrow_back)
            ivSearch.visibility = View.GONE
            tvToolbarTitle.text = resources.getString(R.string.profile)
            tvToolbarTitle.setTextColor(
                ContextCompat.getColor(
                    this@ProfileActivity,
                    R.color.neutral_90
                )
            )
        }
    }

    private fun moveToHome() {
        binding.toolbar.ivToolbarIcon.setOnClickListener {
            @Suppress("DEPRECATION")
            this.onBackPressed()
        }
    }

    private fun logout() {
        binding.btnLogout.setOnClickListener {
            mainViewModel.logout().observe(this) { result ->
                when (result) {
                    is Result.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }

                    is Result.Success -> {
                        binding.progressBar.visibility = View.GONE
                        val intent = Intent(this@ProfileActivity, WelcomeActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(intent)
                        finish()
                    }

                    is Result.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(
                            this@ProfileActivity,
                            getString(R.string.logout_error),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}
