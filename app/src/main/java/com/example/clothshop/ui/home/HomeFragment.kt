package com.example.clothshop.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.clothshop.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    //private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val binding : FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, com.example.clothshop.R.layout.fragment_home, container, false
        )
        val view = binding.root
        binding.homeViewModel = HomeViewModel()

        return view
    }
}