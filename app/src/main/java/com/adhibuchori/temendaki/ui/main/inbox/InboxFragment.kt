package com.adhibuchori.temendaki.ui.main.inbox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adhibuchori.temendaki.R
import com.adhibuchori.temendaki.databinding.FragmentInboxBinding

class InboxFragment : Fragment() {
    private var _binding: FragmentInboxBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInboxBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbar()
    }

    private fun setToolbar() {
        binding.apply {
            with(toolbar) {
                ivToolbarIcon.visibility = View.GONE
                ivSearch.visibility = View.GONE
                tvToolbarTitle.text = resources.getString(R.string.inbox)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}