package com.adhibuchori.temendaki.ui.detail.checkoutConfirm

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.adhibuchori.temendaki.R
import com.adhibuchori.temendaki.databinding.ActivityCheckoutConfirmBinding
import com.adhibuchori.temendaki.databinding.ItemDialogConfirmPaymentBinding
import com.adhibuchori.temendaki.model.TripData
import com.adhibuchori.temendaki.ui.detail.paymentMethod.PaymentMethodActivity
import com.adhibuchori.temendaki.ui.payment.awaitingPayment.AwaitingPaymentActivity
import com.bumptech.glide.Glide
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

class CheckoutConfirmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheckoutConfirmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckoutConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar()
        loadCheckoutConfirmData()
        moveToDetailActivity()
        moveToPaymentMethod()
        actionCheckoutDialog()
        setClimbingDates()
    }

    private fun setClimbingDates() {
        val actvChooseClimbingDates = binding.actvChooseClimbingDates

        val climbingDatesAdapter = ArrayAdapter.createFromResource(
            this@CheckoutConfirmActivity,
            R.array.climbing_dates,
            R.layout.dropdown_item
        )

        val dropdownItemBackground =
            ContextCompat.getDrawable(
                this@CheckoutConfirmActivity,
                R.drawable.dropdown_item_background
            )

        actvChooseClimbingDates.apply {
            setAdapter(climbingDatesAdapter)
            setDropDownBackgroundDrawable(dropdownItemBackground)
        }
    }

    private fun setToolbar() {
        binding.toolbar.apply {
            ivToolbarIcon.setImageResource(R.drawable.ic_arrow_back)
            ivSearch.visibility = View.GONE
            tvToolbarTitle.text = resources.getString(R.string.payment_confirmation)
            tvToolbarTitle.setTextColor(
                ContextCompat.getColor(
                    this@CheckoutConfirmActivity,
                    R.color.neutral_90
                )
            )
        }
    }

    private fun loadCheckoutConfirmData() {
        val tripData = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_TRIP_DATA, TripData::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_TRIP_DATA)
        }

        tripData?.let { data ->
            Glide.with(this)
                .load(data.tripPhotoUrl)
                .into(binding.ivTripPhoto)

            with(binding) {
                tvTripName.text = data.tripName

                val tripPrice = data.tripNominal
                val numberFormat =
                    NumberFormat.getCurrencyInstance(Locale("id", "ID")) as DecimalFormat
                numberFormat.applyPattern("#,###.##")
                val formattedPrice = numberFormat.format(tripPrice)
                tvTripNominal.text = formattedPrice

                val payFormat =
                    NumberFormat.getCurrencyInstance(Locale("id", "ID")) as DecimalFormat
                payFormat.applyPattern("Rp#,###.##")

                var tripNumber = 1

                ivPlusTripQuantity.setOnClickListener {
                    tripNumber++
                    tvTripQuantity.text = tripNumber.toString()
                    updateTotalPay(payFormat, tripNumber, data)
                }

                ivMinTripQuantity.setOnClickListener {
                    if (tripNumber > 1) {
                        tripNumber--
                        tvTripQuantity.text = tripNumber.toString()
                        updateTotalPay(payFormat, tripNumber, data)
                    }
                }

                updateTotalPay(payFormat, tripNumber, data)
            }
        }
    }

    private fun updateTotalPay(payFormat: DecimalFormat, tripNumber: Int, data: TripData) {
        val tripPay = data.tripNominal
        val countPay = payFormat.format(tripPay)
        val countPayNumeric = payFormat.parse(countPay)?.toDouble() ?: 0.0
        val totalPay = countPayNumeric * tripNumber + 998
        val formattedTotalPay = payFormat.format(totalPay)
        binding.tvPay.text = formattedTotalPay
    }

    private fun moveToDetailActivity() {
        binding.toolbar.ivToolbarIcon.setOnClickListener {
            @Suppress("DEPRECATION")
            this.onBackPressed()
        }
    }

    private fun moveToPaymentMethod() {
        binding.cvPaymentMethod.setOnClickListener {
            val moveToPaymentMethod = Intent(this, PaymentMethodActivity::class.java)
            startActivity(moveToPaymentMethod)
        }
    }

    private fun actionCheckoutDialog() {
        binding.btnPay.setOnClickListener {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        val dialogBinding = ItemDialogConfirmPaymentBinding.inflate(layoutInflater)

        val builder = AlertDialog.Builder(this, R.style.DialogStyle)
            .setCancelable(false)

        val alertDialog = builder.create()
        alertDialog.setView(dialogBinding.root)

        alertDialog.window?.apply {
            setBackgroundDrawableResource(android.R.color.transparent)
        }

        dialogBinding.btnOkay.setOnClickListener {
            alertDialog.dismiss()

            val moveToAwaitingPayment =
                Intent(this@CheckoutConfirmActivity, AwaitingPaymentActivity::class.java)
            moveToAwaitingPayment.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(moveToAwaitingPayment)

            Toast.makeText(this@CheckoutConfirmActivity, "Pembelian Berhasil", Toast.LENGTH_SHORT)
                .show()
        }

        alertDialog.show()
    }

    companion object {
        const val EXTRA_TRIP_DATA = "extra_trip"
    }
}
