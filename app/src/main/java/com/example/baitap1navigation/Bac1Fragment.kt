package com.example.baitap1navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.baitap1navigation.databinding.FragmentBac1Binding

class Bac1Fragment : Fragment(R.layout.fragment_bac1),CheckInput {
    private lateinit var binding : FragmentBac1Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBac1Binding.inflate(inflater, container, false)
        (activity as HomeActivity).supportActionBar?.title = "Phương trình bậc 1"
        return binding.root
    }

    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btnTinh.setOnClickListener {
            val aInput = binding.edtNhapA.text.toString()
            val bInput = binding.edtNhapB.text.toString()
            val a = checkInput(aInput).toDouble()
            val b = checkInput(bInput).toDouble()
            if(a==0.0 &&  b==0.0){
                val ketqua = "Phương trình vô số nghiệm"
                val bundle = bundleOf("message" to ketqua)
                findNavController().navigate(R.id.action_bac1Fragment_to_ketquaFragment,bundle)
            }else if (a== 0.0 && b!=0.0){
                val ketqua = "Phương trình vô nghiệm"
                val bundle = bundleOf("message" to ketqua)
                findNavController().navigate(R.id.action_bac1Fragment_to_ketquaFragment,bundle)
            }
            else{
                val ketqua = "Phương trình có nghiệm x=${-b/a}"
                val bundle = bundleOf("message" to ketqua)
                findNavController().navigate(R.id.action_bac1Fragment_to_ketquaFragment, bundle)
            }
        }
    }
}