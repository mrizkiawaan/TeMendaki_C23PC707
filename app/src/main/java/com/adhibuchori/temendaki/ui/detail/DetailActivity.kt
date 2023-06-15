package com.adhibuchori.temendaki.ui.detail

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adhibuchori.temendaki.adapter.SectionsPagerAdapter
import com.adhibuchori.temendaki.databinding.ActivityDetailBinding
import com.adhibuchori.temendaki.model.TripData
import com.adhibuchori.temendaki.ui.detail.checkoutConfirm.CheckoutConfirmActivity
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadDetailTripData()
        setTabAdapter()
        moveToHomeFragment()
        checkAvailability()
    }

    private fun loadDetailTripData() {
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
                numberFormat.applyPattern("Rp#,###.##")
                val formattedPrice = numberFormat.format(tripPrice)
                tvTripNominal.text = formattedPrice

                tvTripLocation.text = data.tripLocation
                tvTripPeriod.text = data.tripPeriod
                tvTripRating.text = data.tripRating.toString()
                tvTripSoldQuantity.text = data.tripSoldQuantity.toString()
            }
        }
    }

    private fun setTabAdapter() {
        val tripData = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_TRIP_DATA, TripData::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_TRIP_DATA)
        }

        tripData?.let {
            val adapter = SectionsPagerAdapter(this, it)
            binding.vpDetailTripInformation.adapter = adapter

            TabLayoutMediator(
                binding.tabDetailTripInformation,
                binding.vpDetailTripInformation
            ) { tab, position ->
                tab.text = when (position) {
                    0 -> "Deskripsi"
                    1 -> "Linimasa"
                    2 -> "Titik Temu"
                    3 -> "Fasilitas"
                    4 -> "Rating"
                    else -> throw IllegalArgumentException("Invalid Tab Position")
                }
            }.attach()
        }
    }

    private fun moveToHomeFragment() {
        binding.ivArrowBack.setOnClickListener {
            @Suppress("DEPRECATION")
            this.onBackPressed()
        }
    }

    private fun checkAvailability() {
        binding.btnCheckAvailability.setOnClickListener {
            @Suppress("DEPRECATION")
            val tripData = intent.getParcelableExtra<TripData>(EXTRA_TRIP_DATA)
            val intentCheckoutConfirmActivity = Intent(this, CheckoutConfirmActivity::class.java)
            intentCheckoutConfirmActivity.putExtra(
                CheckoutConfirmActivity.EXTRA_TRIP_DATA,
                tripData
            )
            startActivity(intentCheckoutConfirmActivity)
        }
    }

    companion object {
        const val EXTRA_TRIP_DATA = "extra_trip"
    }
}