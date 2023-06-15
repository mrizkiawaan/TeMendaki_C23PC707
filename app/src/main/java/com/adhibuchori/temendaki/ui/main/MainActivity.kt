package com.adhibuchori.temendaki.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import com.adhibuchori.temendaki.R
import com.adhibuchori.temendaki.databinding.ActivityMainBinding
import com.adhibuchori.temendaki.ui.auth.welcome.WelcomeActivity
import com.adhibuchori.temendaki.ui.main.history.HistoryFragment
import com.adhibuchori.temendaki.ui.main.home.HomeFragment
import com.adhibuchori.temendaki.ui.main.inbox.InboxFragment
import com.adhibuchori.temendaki.ui.main.wishlist.WishlistFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth")

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory.getInstance(dataStore)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpBottomNavigation()
        isLogin()
        setUpAction()
    }

    private fun setUpAction() {
        replaceFragment(HomeFragment())
    }

    private fun isLogin() {
        mainViewModel.isLogin().observe(this) {
            if (it.isNullOrEmpty()) {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.logout),
                    Toast.LENGTH_SHORT
                ).show()
                startActivity(Intent(this, WelcomeActivity::class.java))
                finish()
            }
        }
    }

    private fun setUpBottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.navigation_history -> HistoryFragment()
                R.id.navigation_home -> HomeFragment()
                R.id.navigation_wishlist -> WishlistFragment()
                R.id.navigation_inbox -> InboxFragment()
                else -> null
            }

            fragment?.let {
                replaceFragment(it)
                true
            } ?: false
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    @Deprecated("Deprecated in Java", ReplaceWith("finish()"))
    override fun onBackPressed() {
        finish()
    }

}