package com.adhibuchori.temendaki.ui.detail.paymentMethod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.adhibuchori.temendaki.R
import com.adhibuchori.temendaki.adapter.ItemRowPaymentMethodAdapter
import com.adhibuchori.temendaki.databinding.ActivityPaymentMethodBinding
import com.adhibuchori.temendaki.model.FakeDataSource
import com.adhibuchori.temendaki.model.PaymentMethodData


class PaymentMethodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentMethodBinding
    private lateinit var paymentMethodAdapter: ItemRowPaymentMethodAdapter
    private lateinit var allPaymentMethod: List<PaymentMethodData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentMethodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadPaymentMethods()
        setToolbar()
        moveToCheckoutConfirmActivity()
    }

    private fun loadPaymentMethods() {
        allPaymentMethod = FakeDataSource.dummyPaymentMethodData
        paymentMethodAdapter = ItemRowPaymentMethodAdapter()

        binding.rvPaymentMethod.apply {
            layoutManager = LinearLayoutManager(this@PaymentMethodActivity)
            adapter = paymentMethodAdapter
        }

        paymentMethodAdapter.submitList(allPaymentMethod)
    }

    private fun setToolbar() {
        binding.toolbar.apply {
            ivToolbarIcon.setImageResource(R.drawable.ic_arrow_back)
            ivSearch.visibility = View.GONE
            tvToolbarTitle.text = resources.getString(R.string.payment_method)
            tvToolbarTitle.setTextColor(
                ContextCompat.getColor(
                    this@PaymentMethodActivity,
                    R.color.neutral_90
                )
            )
        }
    }

    private fun moveToCheckoutConfirmActivity() {
        binding.toolbar.ivToolbarIcon.setOnClickListener {
            @Suppress("DEPRECATION")
            this.onBackPressed()
        }
    }
}