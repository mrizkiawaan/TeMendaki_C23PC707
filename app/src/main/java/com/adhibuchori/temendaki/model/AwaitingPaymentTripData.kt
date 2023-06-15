package com.adhibuchori.temendaki.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class AwaitingPaymentTripData(
    @field:ColumnInfo(name = "Id")
    @field:PrimaryKey
    val tripId: Long,

    @field:ColumnInfo(name = "TripDate")
    val tripDate: String,

    @field:ColumnInfo(name = "TripPhotoUrl")
    val tripPhotoUrl: String,

    @field:ColumnInfo(name = "TripName")
    val tripName: String,

    @field:ColumnInfo(name = "TripPeriod")
    val tripPeriod: String,

    @field:ColumnInfo(name = "TripPerson")
    val tripPerson: Int,

    @field:ColumnInfo(name = "TripPaymentMethodPhotoUrl")
    val tripPaymentMethodPhotoUrl: String,

    @field:ColumnInfo(name = "TripSenderAccountNumber")
    val tripSenderAccountNumber: Int,

    @field:ColumnInfo(name = "TripSenderAccountName")
    val tripSenderAccountName: String,

    @field:ColumnInfo(name = "TripPrice")
    val tripPrice: Int
)