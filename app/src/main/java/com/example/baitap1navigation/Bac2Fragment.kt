@file:Suppress("DEPRECATION")

package com.example.baitap1navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.baitap1navigation.databinding.FragmentBac2Binding

class Bac2Fragment : Fragment(R.layout.fragment_bac2), CheckInput {
    private lateinit var binding : FragmentBac2Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBac2Binding.inflate(inflater,container,false)
        (activity as HomeActivity).supportActionBar?.title="Phương trình bậc 2"
        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       binding.btnTinh.setOnClickListener {
           val aInput = binding.edtNhapA.text.toString()
           val bInput = binding.edtNhapB.text.toString()
           val cInput = binding.edtNhapC.text.toString()
           val a = checkInput(aInput).toDouble()
           val b = checkInput(bInput).toDouble()
           val c = checkInput(cInput).toDouble()
           val delta = b*b - 4*a*c
           if(delta<0.0){
               val ketqua = "Phương trình vô nghiệm"
               val bundle = bundleOf("message" to ketqua)
               findNavController().navigate(R.id.action_bac2Fragment_to_ketquaFragment,bundle)
           }else if(delta == 0.0){
               val ketqua = "Phương trình có nghiệm kép x1=x2=${-b/(2*a)}"
               val bundle = bundleOf("message" to ketqua)
               findNavController().navigate(R.id.action_bac2Fragment_to_ketquaFragment,bundle)
           }else{
               val ketqua ="Phương trình có 2 nghiệm phân biệt x1=${(-b+Math.sqrt(delta))/(2*a)} và x2=${(-b-Math.sqrt(delta))/(2*a)}"
               val bundle = bundleOf("message" to ketqua)
               findNavController().navigate(R.id.action_bac2Fragment_to_ketquaFragment,bundle)
           }
       }
    }
}