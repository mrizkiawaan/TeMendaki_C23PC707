package com.adhibuchori.temendaki.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adhibuchori.temendaki.R
import com.adhibuchori.temendaki.databinding.ItemRowAwaitingPaymentBinding
import com.adhibuchori.temendaki.model.AwaitingPaymentTripData
import com.adhibuchori.temendaki.ui.payment.awaitingPayment.AwaitingPaymentActivity
import com.adhibuchori.temendaki.ui.payment.howToPay.HowToPayActivity
import com.bumptech.glide.Glide
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

class ItemRowAwaitingPaymentAdapter :
    ListAdapter<AwaitingPaymentTripData, ItemRowAwaitingPaymentAdapter.ListViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowAwaitingPaymentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val tripData = getItem(position)
        holder.bind(tripData)
    }

    inner class ListViewHolder(private val binding: ItemRowAwaitingPaymentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.btnSeeHowToPay.setOnClickListener {
                val context = binding.root.context
                val moveToHowToPay = Intent(context, HowToPayActivity::class.java)
                context.startActivity(moveToHowToPay)
            }
        }

        fun bind(awaitingPaymentTripData: AwaitingPaymentTripData) {
            with(binding) {
                Glide.with(root.context)
                    .load(awaitingPaymentTripData.tripPhotoUrl)
                    .into(ivTripPhoto)

                Glide.with(root.context)
                    .load(awaitingPaymentTripData.tripPaymentMethodPhotoUrl)
                    .into(ivTripPaymentMethodPhoto)

                tvTripDate.text = awaitingPaymentTripData.tripDate
                tvTripName.text = awaitingPaymentTripData.tripName
                tvTripPeriod.text = awaitingPaymentTripData.tripPeriod
                tvTripPerson.text = String.format("%d Orang", awaitingPaymentTripData.tripPerson)

                val tripPrice = awaitingPaymentTripData.tripPrice
                val numberFormat =
                    NumberFormat.getCurrencyInstance(Locale("id", "ID")) as DecimalFormat
                numberFormat.applyPattern("Rp#,###.##")
                val formattedPrice = numberFormat.format(tripPrice)
                tvTripPrice.text = formattedPrice

                val tripSenderAccountNameFormat =
                    root.context.resources.getString(R.string.trip_sender_account_name)
                val formattedTripSenderAccountName = String.format(
                    tripSenderAccountNameFormat,
                    awaitingPaymentTripData.tripSenderAccountName
                )
                tvTripSenderAccountName.text = formattedTripSenderAccountName

                tvTripSenderAccountNumber.text =
                    awaitingPaymentTripData.tripSenderAccountNumber.toString()
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<AwaitingPaymentTripData>() {
        override fun areItemsTheSame(
            oldItem: AwaitingPaymentTripData,
            newItem: AwaitingPaymentTripData
        ): Boolean {
            return oldItem.tripId == newItem.tripId
        }

        override fun areContentsTheSame(
            oldItem: AwaitingPaymentTripData,
            newItem: AwaitingPaymentTripData
        ): Boolean {
            return oldItem == newItem
        }
    }
}
