package com.adhibuchori.temendaki.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adhibuchori.temendaki.model.FakeDataSource
import com.adhibuchori.temendaki.model.TripData

class HomeViewModel : ViewModel() {

    private val _trips = MutableLiveData<List<TripData>>()
    val trips: LiveData<List<TripData>> get() = _trips

    fun loadTrips() {
        _trips.value = FakeDataSource.dummyTripData
    }
}