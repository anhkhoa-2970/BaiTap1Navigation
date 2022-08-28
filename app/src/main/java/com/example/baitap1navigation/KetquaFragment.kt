package com.example.baitap1navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.baitap1navigation.databinding.FragmentKetquaBinding

class KetquaFragment : Fragment(R.layout.fragment_ketqua) {
    private lateinit var binding : FragmentKetquaBinding

    private var inputText : String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKetquaBinding.inflate(inflater, container, false)
        (activity as HomeActivity).supportActionBar?.title =  getString(R.string.title_ketqua_fragment)
        inputText = arguments?.getString("message")
        binding.tvketqua.text = inputText.toString()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        val ketqua = bundle?.getString("message")
        binding.tvketqua.text = ketqua
    }
}