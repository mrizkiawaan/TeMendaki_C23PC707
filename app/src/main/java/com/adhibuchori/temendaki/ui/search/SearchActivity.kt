package com.adhibuchori.temendaki.ui.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adhibuchori.temendaki.databinding.ActivitySearchBinding
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.adhibuchori.temendaki.adapter.ItemRowTripAdapter
import com.adhibuchori.temendaki.model.FakeDataSource
import com.adhibuchori.temendaki.model.TripData
import com.adhibuchori.temendaki.ui.detail.DetailActivity

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var tripAdapter: ItemRowTripAdapter
    private lateinit var allTrips: List<TripData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val activateSearch = intent.getBooleanExtra("activateSearch", false)
        if (activateSearch) {
            binding.svTrip.isIconified = false
        }

        allTrips = FakeDataSource.dummyTripData
        tripAdapter = ItemRowTripAdapter()

        binding.rvSearchResults.apply {
            layoutManager = LinearLayoutManager(this@SearchActivity)
            adapter = tripAdapter
        }

        searchTrip()
        moveToHomeFragment()
    }

    private fun searchTrip() {
        binding.svTrip.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                performSearch(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                performSearch(newText)
                return true
            }
        })
    }

    private fun performSearch(query: String) {
        val filteredTrips = allTrips.filter { trip ->
            trip.tripName.contains(query, ignoreCase = true)
        }

        tripAdapter.setOnItemClickCallback(object : ItemRowTripAdapter.OnItemClickCallback {
            override fun onItemClicked(tripData: TripData) {
                moveToDetailTripFragment(tripData)
            }
        })

        tripAdapter.submitList(filteredTrips)
    }

    private fun moveToDetailTripFragment(tripData: TripData) {
        val intentToDetailActivity = Intent(this@SearchActivity, DetailActivity::class.java)
        intentToDetailActivity.putExtra(DetailActivity.EXTRA_TRIP_DATA, tripData)
        startActivity(intentToDetailActivity)
    }

    private fun moveToHomeFragment() {
        binding.ivArrowBack.setOnClickListener {
            @Suppress("DEPRECATION")
            this.onBackPressed()
        }
    }
}