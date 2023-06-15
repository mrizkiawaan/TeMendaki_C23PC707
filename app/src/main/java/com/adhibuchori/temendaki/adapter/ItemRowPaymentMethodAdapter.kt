package com.adhibuchori.temendaki.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adhibuchori.temendaki.databinding.ItemRowPaymentMethodBinding
import com.adhibuchori.temendaki.model.PaymentMethodData
import com.adhibuchori.temendaki.ui.detail.checkoutConfirm.CheckoutConfirmActivity
import com.bumptech.glide.Glide


class ItemRowPaymentMethodAdapter :
    ListAdapter<PaymentMethodData, ItemRowPaymentMethodAdapter.ListViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRowPaymentMethodBinding.inflate(inflater, parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val paymentMethodData = getItem(position)
        holder.bind(paymentMethodData)
    }

    inner class ListViewHolder(private val binding: ItemRowPaymentMethodBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(paymentMethodData: PaymentMethodData) {
            with(binding) {
                Glide.with(root.context)
                    .load(paymentMethodData.paymentMethodPhotoUrl)
                    .into(ivPaymentMethod)
                tvPaymentMethod.text = paymentMethodData.paymentMethodName

                itemView.setOnClickListener {
                    val context = itemView.context
                    @Suppress("DEPRECATION")
                    (context as? AppCompatActivity)?.onBackPressed()
                }
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<PaymentMethodData>() {
        override fun areItemsTheSame(
            oldItem: PaymentMethodData,
            newItem: PaymentMethodData
        ): Boolean {
            return oldItem.paymentMethodId == newItem.paymentMethodId
        }

        override fun areContentsTheSame(
            oldItem: PaymentMethodData,
            newItem: PaymentMethodData
        ): Boolean {
            return oldItem == newItem
        }
    }
}