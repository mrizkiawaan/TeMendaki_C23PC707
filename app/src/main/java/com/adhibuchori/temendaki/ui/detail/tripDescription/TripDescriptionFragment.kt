package com.adhibuchori.temendaki.ui.detail.tripDescription

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adhibuchori.temendaki.databinding.FragmentTripDescriptionBinding
import com.adhibuchori.temendaki.model.TripData

class TripDescriptionFragment : Fragment() {

    private var _binding: FragmentTripDescriptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTripDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getTripData()
    }

    private fun getTripData() {
        @Suppress("DEPRECATION")
        val tripData = arguments?.getParcelable<TripData>(ARG_TRIP_DATA)
        tripData?.let {
            binding.tvTripDescription.text = tripData.tripDescription
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ARG_TRIP_DATA = "arg_trip_data"

        fun newInstance(tripData: TripData): Fragment {
            val fragment = TripDescriptionFragment()
            val bundle = Bundle().apply {
                putParcelable(ARG_TRIP_DATA, tripData)
            }
            fragment.arguments = bundle
            return fragment
        }
    }
}
