package com.adhibuchori.temendaki.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adhibuchori.temendaki.R
import com.adhibuchori.temendaki.databinding.ItemRowHistoryBinding
import com.adhibuchori.temendaki.model.HistoryTripData
import com.bumptech.glide.Glide
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

class ItemRowHistoryAdapter :
    ListAdapter<HistoryTripData, ItemRowHistoryAdapter.ListViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemRowHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val historyTripData = getItem(position)
        holder.bind(historyTripData)
    }

    inner class ListViewHolder(private val binding: ItemRowHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(historyTripData: HistoryTripData) {
            with(binding) {
                Glide.with(root.context)
                    .load(historyTripData.tripPhotoUrl)
                    .into(ivTripPhoto)

                tvTripDate.text = historyTripData.tripDate
                tvTripName.text = historyTripData.tripName
                tvTripPeriod.text = historyTripData.tripPeriod
                tvTripPerson.text = String.format("%d Orang", historyTripData.tripPerson)
                tvTripTime.text = historyTripData.tripTime

                val tripPrice = historyTripData.tripPrice
                val numberFormat = NumberFormat.getCurrencyInstance(Locale("id", "ID")) as DecimalFormat
                numberFormat.applyPattern("Rp#,###.##")
                val formattedPrice = numberFormat.format(tripPrice)
                tvTripPrice.text = formattedPrice

                when (historyTripData.tripStatus) {
                    "Belum Selesai" -> {
                        tvTripStatus.text = historyTripData.tripStatus
                        tvTripStatus.setTextColor(ContextCompat.getColor(root.context, R.color.warning_pressed))
                        cvTripStatus.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.warning_surface))
                    }
                    "Selesai" -> {
                        tvTripStatus.text = historyTripData.tripStatus
                        tvTripStatus.setTextColor(ContextCompat.getColor(root.context, R.color.success_pressed))
                        cvTripStatus.setCardBackgroundColor(ContextCompat.getColor(root.context, R.color.success_surface))
                    }
                }
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<HistoryTripData>() {
        override fun areItemsTheSame(oldItem: HistoryTripData, newItem: HistoryTripData): Boolean {
            return oldItem.tripId == newItem.tripId
        }

        override fun areContentsTheSame(
            oldItem: HistoryTripData,
            newItem: HistoryTripData
        ): Boolean {
            return oldItem == newItem
        }
    }
}
