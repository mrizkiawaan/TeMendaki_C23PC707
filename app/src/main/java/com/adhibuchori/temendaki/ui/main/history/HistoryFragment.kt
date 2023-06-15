package com.adhibuchori.temendaki.ui.main.history

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.adhibuchori.temendaki.R
import com.adhibuchori.temendaki.adapter.ItemRowHistoryAdapter
import com.adhibuchori.temendaki.databinding.FragmentHistoryBinding
import com.adhibuchori.temendaki.ui.payment.awaitingPayment.AwaitingPaymentActivity

class HistoryFragment : Fragment() {
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    private lateinit var historyTripAdapter: ItemRowHistoryAdapter

    private val viewModel: HistoryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbar()
        loadTripHistory()
        moveToAwaitingPayment()
    }

    private fun loadTripHistory() {
        historyTripAdapter = ItemRowHistoryAdapter()

        binding.rvTripHistory.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = historyTripAdapter
        }

        viewModel.loadTripHistory()
        viewModel.tripHistory.observe(viewLifecycleOwner) { tripList ->
            historyTripAdapter.submitList(tripList)
        }
    }

    private fun setToolbar() {
        binding.toolbar.apply {
            ivToolbarIcon.visibility = View.GONE
            ivSearch.visibility = View.GONE
            tvToolbarTitle.text = resources.getString(R.string.history)
        }
    }

    private fun moveToAwaitingPayment() {
        binding.cvAwaitingPayment.setOnClickListener {
            val moveToAwaitingPayment =
                Intent(requireActivity(), AwaitingPaymentActivity::class.java)
            startActivity(moveToAwaitingPayment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}