package com.adhibuchori.temendaki.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class PaymentMethodData(
    @field:ColumnInfo(name = "Id")
    @field:PrimaryKey
    val paymentMethodId: Long,

    @field:ColumnInfo(name = "PaymentMethodName")
    val paymentMethodName: String,

    @field:ColumnInfo(name = "PaymentMethodPhotoUrl")
    val paymentMethodPhotoUrl: String
)