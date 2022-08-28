package com.example.baitap1navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.baitap1navigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container, false)
        (activity as HomeActivity).supportActionBar?.title ="Toán học"
        return binding.root
    }

    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val controller = findNavController()
        binding.btncongtru.setOnClickListener {
            controller.navigate(R.id.congtruFragment)
        }
        binding.btnbac1.setOnClickListener {
            controller.navigate(R.id.bac1Fragment)
        }
        binding.btnbac2.setOnClickListener {
            controller.navigate(R.id.bac2Fragment)
        }
    }
}