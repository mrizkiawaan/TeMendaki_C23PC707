package com.adhibuchori.temendaki.ui.payment.awaitingPayment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.adhibuchori.temendaki.R
import com.adhibuchori.temendaki.adapter.ItemRowAwaitingPaymentAdapter
import com.adhibuchori.temendaki.databinding.ActivityAwaitingPaymentBinding
import com.adhibuchori.temendaki.ui.main.MainActivity

class AwaitingPaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAwaitingPaymentBinding

    private lateinit var awaitingPaymentTripAdapter: ItemRowAwaitingPaymentAdapter

    private val viewModel: AwaitingPaymentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAwaitingPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadTripAwaitingPayment()
        setToolbar()
        moveToHome()
    }

    private fun loadTripAwaitingPayment() {
        awaitingPaymentTripAdapter = ItemRowAwaitingPaymentAdapter()

        binding.rvTripAwaitingPayment.apply {
            layoutManager = LinearLayoutManager(this@AwaitingPaymentActivity)
            adapter = awaitingPaymentTripAdapter
        }

        viewModel.loadTripAwaitingPayment()
        viewModel.tripAwaitingPayment.observe(this) { tripList ->
            awaitingPaymentTripAdapter.submitList(tripList)
        }
    }

    private fun setToolbar() {
        binding.toolbar.apply {
            ivToolbarIcon.setImageResource(R.drawable.ic_arrow_back)
            ivSearch.visibility = View.GONE
            tvToolbarTitle.text = resources.getString(R.string.awaiting_payment)
            tvToolbarTitle.setTextColor(
                ContextCompat.getColor(
                    this@AwaitingPaymentActivity,
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

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val backToMain = Intent(this, MainActivity::class.java)
        startActivity(backToMain)
        finish()
    }
}