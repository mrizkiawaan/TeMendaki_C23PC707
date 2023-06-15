package com.adhibuchori.temendaki.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adhibuchori.temendaki.databinding.ItemRowTripBinding
import com.adhibuchori.temendaki.model.TripData
import com.bumptech.glide.Glide
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

class ItemRowTripAdapter :
    ListAdapter<TripData, ItemRowTripAdapter.ListViewHolder>(DiffCallback()) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowTripBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val tripData = getItem(position)
        holder.bind(tripData)
    }

    inner class ListViewHolder(private val binding: ItemRowTripBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                @Suppress("DEPRECATION")
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val tripData = getItem(position)
                    onItemClickCallback.onItemClicked(tripData)
                }
            }
        }

        fun bind(tripData: TripData) {
            with(binding) {
                Glide.with(root.context)
                    .load(tripData.tripPhotoUrl)
                    .into(ivTripPhoto)

                tvTripName.text = tripData.tripName

                val tripPrice = tripData.tripNominal
                val numberFormat = NumberFormat.getCurrencyInstance(Locale("id", "ID")) as DecimalFormat
                numberFormat.applyPattern("#,###.##")
                val formattedPrice = numberFormat.format(tripPrice)
                tvTripNominal.text = formattedPrice

                tvTripDay.text = tripData.tripDay
                tvTripRating.text = tripData.tripRating.toString()
                tvTripSoldQuantity.text = tripData.tripSoldQuantity.toString()
            }
        }
    }


    private class DiffCallback : DiffUtil.ItemCallback<TripData>() {
        override fun areItemsTheSame(oldItem: TripData, newItem: TripData): Boolean {
            return oldItem.tripId == newItem.tripId
        }

        override fun areContentsTheSame(oldItem: TripData, newItem: TripData): Boolean {
            return oldItem == newItem
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(tripData: TripData)
    }
}

