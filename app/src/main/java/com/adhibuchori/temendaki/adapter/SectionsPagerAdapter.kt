package com.adhibuchori.temendaki.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.adhibuchori.temendaki.model.TripData
import com.adhibuchori.temendaki.ui.detail.tripDescription.TripDescriptionFragment
import com.adhibuchori.temendaki.ui.detail.tripFacilities.TripFacilitiesFragment
import com.adhibuchori.temendaki.ui.detail.tripMeetingPoint.TripMeetingPointFragment
import com.adhibuchori.temendaki.ui.detail.tripRating.TripRatingFragment
import com.adhibuchori.temendaki.ui.detail.tripTimeline.TripTimelineFragment

class SectionsPagerAdapter(activity: AppCompatActivity, private val tripData: TripData) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TripDescriptionFragment.newInstance(tripData)
            1 -> TripTimelineFragment()
            2 -> TripMeetingPointFragment()
            3 -> TripFacilitiesFragment()
            4 -> TripRatingFragment()
            else -> throw IllegalArgumentException("Invalid Tab Position")
        }
    }

    override fun getItemCount(): Int {
        return 5
    }
}
