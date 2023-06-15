package com.adhibuchori.temendaki.ui.main.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adhibuchori.temendaki.model.FakeDataSource
import com.adhibuchori.temendaki.model.HistoryTripData

class HistoryViewModel : ViewModel() {
    private val _tripHistory = MutableLiveData<List<HistoryTripData>>()
    val tripHistory: LiveData<List<HistoryTripData>> get() = _tripHistory

    fun loadTripHistory() {
        _tripHistory.value = FakeDataSource.dummyHistoryTripData
    }
}