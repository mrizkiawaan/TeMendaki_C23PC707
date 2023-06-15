package com.adhibuchori.temendaki.ui.payment.howToPay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.adhibuchori.temendaki.R
import com.adhibuchori.temendaki.databinding.ActivityHowToPayBinding

class HowToPayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHowToPayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHowToPayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        moveToAwaitingPayment()
        setToolbar()
    }

    private fun setToolbar() {
        binding.toolbar.apply {
            ivToolbarIcon.setImageResource(R.drawable.ic_arrow_back)
            ivSearch.visibility = View.GONE
            tvToolbarTitle.text = resources.getString(R.string.how_to_pay)
            tvToolbarTitle.setTextColor(
                ContextCompat.getColor(
                    this@HowToPayActivity,
                    R.color.neutral_90
                )
            )
        }
    }

    private fun moveToAwaitingPayment() {
        binding.toolbar.ivToolbarIcon.setOnClickListener {
            @Suppress("DEPRECATION")
            this.onBackPressed()
        }
    }
}