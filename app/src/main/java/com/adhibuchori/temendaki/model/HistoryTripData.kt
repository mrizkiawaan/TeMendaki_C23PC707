package com.adhibuchori.temendaki.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class HistoryTripData (
    @field:ColumnInfo(name = "Id")
    @field:PrimaryKey
    val tripId: Long,

    @field:ColumnInfo(name = "TripDate")
    val tripDate: String,

    @field:ColumnInfo(name = "TripStatus")
    val tripStatus: String,

    @field:ColumnInfo(name = "TripPhotoUrl")
    val tripPhotoUrl: String,

    @field:ColumnInfo(name = "TripName")
    val tripName: String,

    @field:ColumnInfo(name = "TripPeriod")
    val tripPeriod: String,

    @field:ColumnInfo(name = "TripPerson")
    val tripPerson: Int,

    @field:ColumnInfo(name = "TripTime")
    val tripTime: String,

    @field:ColumnInfo(name = "TripPrice")
    val tripPrice: Int
)