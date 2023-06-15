package com.adhibuchori.temendaki.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "FavouriteTrip")
data class TripData(

    @field:ColumnInfo(name = "Id")
    @field:PrimaryKey
    val tripId: Long,

    @field:ColumnInfo(name = "TripPhotoUrl")
    val tripPhotoUrl: String,

    @field:ColumnInfo(name = "TripName")
    val tripName: String,

    @field:ColumnInfo(name = "TripNominal")
    val tripNominal: Int,

    @field:ColumnInfo(name = "TripDay")
    val tripDay: String,

    @field:ColumnInfo(name = "TripRating")
    val tripRating: Double,

    @field:ColumnInfo(name = "tripSoldQuantity")
    val tripSoldQuantity: Int,

    @field:ColumnInfo(name = "tripDescription")
    val tripDescription: String,

    @field:ColumnInfo(name = "tripPeriod")
    val tripPeriod: String,

    @field:ColumnInfo(name = "tripLocation")
    val tripLocation: String


) : Parcelable