package com.adhibuchori.temendaki.ui.main.home

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.adhibuchori.temendaki.R
import com.adhibuchori.temendaki.adapter.ItemRowTripAdapter
import com.adhibuchori.temendaki.databinding.FragmentHomeBinding
import com.adhibuchori.temendaki.model.TripData
import com.adhibuchori.temendaki.ui.detail.DetailActivity
import com.adhibuchori.temendaki.ui.main.hikingGuide.HikingGuideActivity
import com.adhibuchori.temendaki.ui.main.maps.MapsActivity
import com.adhibuchori.temendaki.ui.main.profile.ProfileActivity
import com.adhibuchori.temendaki.ui.search.SearchActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.io.IOException
import java.util.Locale

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var tripAdapter: ItemRowTripAdapter

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var location: Location? = null

    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadTrips()
        searchTrips()
        moveToProfile()
        moveToHikingGuide()

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        setUpLocation()
    }

    private fun setUpLocation() {
        if (allPermissionsGranted(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        ) {
            getMyLastLocation()
        } else {
            locationPermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }

        binding.apply {
            ivLocationRefresh.setOnClickListener {
                getMyLastLocation()
            }
            cvMyLocation.setOnClickListener {
                val moveToMaps = Intent(requireContext(), MapsActivity::class.java)
                startActivity(moveToMaps)
            }
        }
    }

    private fun getCityName() {
        val geocoder = Geocoder(requireContext(), Locale.getDefault())
        try {
            @Suppress("DEPRECATION")
            val addresses = geocoder.getFromLocation(
                location?.latitude ?: 0.0,
                location?.longitude ?: 0.0,
                1
            )
            if (!addresses.isNullOrEmpty()) {
                val cityName = addresses[0]?.adminArea
                if (cityName != null) {
                    binding.tvMyLocation.text = cityName
                } else {
                    showToast(getString(R.string.location_error))
                }
            }
        } catch (e: IOException) {
            showToast(getString(R.string.location_error))
        }
    }

    private fun allPermissionsGranted(vararg permissions: String): Boolean {
        return permissions.all {
            ContextCompat.checkSelfPermission(
                requireContext(),
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    private val locationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val fineLocationGranted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] ?: false
        val coarseLocationGranted = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] ?: false

        if (fineLocationGranted || coarseLocationGranted) {
            getMyLastLocation()
        } else {
            showToast(getString(R.string.allow_permission))
        }
    }

    private fun getMyLastLocation() {
        val fineLocationGranted = allPermissionsGranted(Manifest.permission.ACCESS_FINE_LOCATION)
        val coarseLocationGranted =
            allPermissionsGranted(Manifest.permission.ACCESS_COARSE_LOCATION)

        if (fineLocationGranted && coarseLocationGranted) {
            try {
                fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                    location?.let {
                        this.location = it
                        getCityName()
                    } ?: run {
                        showToast(getString(R.string.location_error))
                    }
                }
            } catch (e: SecurityException) {
                showToast(getString(R.string.location_permission_error))
            }
        } else {
            locationPermissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun searchTrips() {
        binding.toolbar.ivSearch.setOnClickListener {
            val moveToSearchActivity = Intent(requireContext(), SearchActivity::class.java)
            moveToSearchActivity.putExtra("activateSearch", true)
            startActivity(moveToSearchActivity)
        }
    }

    private fun loadTrips() {
        tripAdapter = ItemRowTripAdapter()

        binding.rvTrip.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = tripAdapter
        }

        tripAdapter.setOnItemClickCallback(object : ItemRowTripAdapter.OnItemClickCallback {
            override fun onItemClicked(tripData: TripData) {
                moveToDetailTrip(tripData)
            }
        })

        viewModel.trips.observe(viewLifecycleOwner) { tripList ->
            tripAdapter.submitList(tripList)
        }

        viewModel.loadTrips()
    }

    private fun moveToDetailTrip(tripData: TripData) {
        val intentToDetailActivity = Intent(requireContext(), DetailActivity::class.java)
        intentToDetailActivity.putExtra(DetailActivity.EXTRA_TRIP_DATA, tripData)
        startActivity(intentToDetailActivity)
    }

    private fun moveToProfile() {
        binding.imgProfile.setOnClickListener {
            val moveToProfile = Intent(requireContext(), ProfileActivity::class.java)
            startActivity(moveToProfile)
        }
    }

    private fun moveToHikingGuide() {
        binding.cvHikingGuide.setOnClickListener {
            val moveToHikingGuide = Intent(requireContext(), HikingGuideActivity::class.java)
            startActivity(moveToHikingGuide)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
