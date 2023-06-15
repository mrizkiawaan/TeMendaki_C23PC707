package com.adhibuchori.temendaki.ui.detail.tripMeetingPoint

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adhibuchori.temendaki.databinding.FragmentTripMeetingPointBinding

class TripMeetingPointFragment : Fragment() {

    private var _binding: FragmentTripMeetingPointBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTripMeetingPointBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
