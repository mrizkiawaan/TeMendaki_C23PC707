package com.adhibuchori.temendaki.ui.auth.signup

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.adhibuchori.temendaki.R
import com.adhibuchori.temendaki.databinding.ActivitySignupBinding
import com.adhibuchori.temendaki.ui.auth.AuthViewModel
import com.adhibuchori.temendaki.ui.auth.AuthViewModelFactory
import com.adhibuchori.temendaki.data.remote.utils.Result

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth")

    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModelFactory.getInstance(dataStore)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        register()
    }

    private fun register() {
        binding.apply {

            val actvChooseProvince = actvChooseProvince
            val actvChooseClimbingExperienceLevels = actvChooseClimbingExperienceLevels

            val provinceAdapter = ArrayAdapter.createFromResource(
                this@SignupActivity,
                R.array.provinces,
                R.layout.dropdown_item
            )

            val climbingExperienceLevelsAdapter = ArrayAdapter.createFromResource(
                this@SignupActivity,
                R.array.climbing_levels,
                R.layout.dropdown_item
            )

            val dropdownItemBackground =
                ContextCompat.getDrawable(
                    this@SignupActivity,
                    R.drawable.dropdown_item_background
                )

            actvChooseProvince.apply {
                setAdapter(provinceAdapter)
                setDropDownBackgroundDrawable(dropdownItemBackground)
            }

            actvChooseClimbingExperienceLevels.apply {
                setAdapter(climbingExperienceLevelsAdapter)
                setDropDownBackgroundDrawable(dropdownItemBackground)
            }

            btnSignup.setOnClickListener {

                val username = tietName.text.toString()
                val email = tietEmail.text.toString()
                val province = actvChooseProvince.text.toString()
                val climbingExperienceLevels = actvChooseClimbingExperienceLevels.text.toString()
                val password = tietPassword.text.toString()
                val confirmPassword = tietPassword.text.toString()

                when {
                    username.isEmpty() -> {
                        tilName.error = "Masukkan Nama Lengkap"
                    }

                    email.isEmpty() -> {
                        tilEmail.error = "Masukkan Email"
                    }

                    password.isEmpty() -> {
                        tilPassword.error = "Masukkan Kata Sandi"
                    }

                    confirmPassword.isEmpty() -> {
                        tilConfirmPassword.error = "Konfirmasi Kata Sandi"
                    }

                    Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 8 -> {

                        tietName.onEditorAction(EditorInfo.IME_ACTION_DONE)
                        tietEmail.onEditorAction(EditorInfo.IME_ACTION_DONE)
                        tietPassword.onEditorAction(EditorInfo.IME_ACTION_DONE)
                        tietConfirmPassword.onEditorAction(EditorInfo.IME_ACTION_DONE)

                        authViewModel.register(
                            username,
                            email,
                            province,
                            climbingExperienceLevels,
                            password,
                            confirmPassword
                        )
                            .observe(this@SignupActivity) { result ->
                                when (result) {
                                    is Result.Loading -> {
                                        progressBar.visibility = View.VISIBLE
                                    }

                                    is Result.Success -> {
                                        progressBar.visibility = View.GONE
                                        AlertDialog.Builder(this@SignupActivity).apply {
                                            setTitle("Yeah!")
                                            setMessage("Akunnya sudah jadi nih. Yuk, login dan cari trip pendakianmu!.")
                                            setPositiveButton("Lanjut") { _, _ ->
                                                finish()
                                            }
                                            create()
                                            show()
                                        }
                                    }

                                    is Result.Error -> {
                                        progressBar.visibility = View.GONE
                                        Toast.makeText(
                                            this@SignupActivity,
                                            result.error,
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            }
                    }
                }
            }
        }
    }
}