package com.adhibuchori.temendaki.ui.payment.awaitingPayment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adhibuchori.temendaki.model.AwaitingPaymentTripData
import com.adhibuchori.temendaki.model.FakeDataSource

class AwaitingPaymentViewModel : ViewModel() {
    private val _tripAwaitingPayment = MutableLiveData<List<AwaitingPaymentTripData>>()
    val tripAwaitingPayment: LiveData<List<AwaitingPaymentTripData>> get() = _tripAwaitingPayment

    fun loadTripAwaitingPayment() {
        _tripAwaitingPayment.value = FakeDataSource.dummyAwaitingPaymentTripData
    }
}