package com.adhibuchori.temendaki.ui.auth.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.activity.viewModels
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.adhibuchori.temendaki.R
import com.adhibuchori.temendaki.databinding.ActivityLoginBinding
import com.adhibuchori.temendaki.ui.auth.AuthViewModel
import com.adhibuchori.temendaki.ui.auth.AuthViewModelFactory
import com.adhibuchori.temendaki.ui.main.MainActivity
import com.adhibuchori.temendaki.data.remote.utils.Result

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth")

    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModelFactory.getInstance(dataStore)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        login()
    }

    private fun login() {
        binding.apply {
            btnLogin.setOnClickListener {
                val email = binding.tietEmail.text.toString()
                val password = binding.tietPassword.text.toString()

                when {
                    email.isEmpty() -> {
                        binding.tilEmail.error = "Tolong Masukkan Email"
                    }

                    password.isEmpty() -> {
                        binding.tilPassword.error = "Tolong Masukkan Password"
                    }

                    Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 8 -> {
                        binding.apply {
                            tietEmail.onEditorAction(EditorInfo.IME_ACTION_DONE)
                            tietPassword.onEditorAction(EditorInfo.IME_ACTION_DONE)
                        }
                        authViewModel.login(email, password).observe(this@LoginActivity) { result ->
                            when (result) {
                                is Result.Loading -> {
                                    binding.progressBar.visibility = View.VISIBLE
                                }

                                is Result.Success -> {
                                    val intent =
                                        Intent(this@LoginActivity, MainActivity::class.java)
                                    intent.flags =
                                        Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                                    startActivity(intent)
                                    finish()

                                    binding.progressBar.visibility = View.GONE
                                    Toast.makeText(
                                        this@LoginActivity,
                                        getString(R.string.login_success),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                is Result.Error -> {
                                    binding.progressBar.visibility = View.GONE
                                    Toast.makeText(
                                        this@LoginActivity,
                                        getString(R.string.login_wrong),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                    }

                    else -> {
                        Toast.makeText(
                            this@LoginActivity,
                            getString(R.string.register_invalid),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}