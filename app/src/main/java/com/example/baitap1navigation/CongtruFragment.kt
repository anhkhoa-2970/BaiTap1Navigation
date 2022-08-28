package com.example.baitap1navigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.baitap1navigation.databinding.FragmentCongtruBinding

@Suppress("DEPRECATION", "NAME_SHADOWING")
class CongtruFragment : Fragment(R.layout.fragment_congtru), CheckInput {
    private lateinit var binding: FragmentCongtruBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCongtruBinding.inflate(inflater, container, false)
        (activity as HomeActivity).supportActionBar?.setTitle(R.string.title_congtru_fragment)
        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btnCong.setOnClickListener {
            caculator() { a, b -> a + b }
        }
        binding.btnTru.setOnClickListener {
            caculator() { a, b -> a - b }
        }
        binding.btnNhan.setOnClickListener {
            caculator() { a, b -> a * b }
        }
        binding.btnChia.setOnClickListener {
            val bInput = binding.edtNhapB.text.toString().toDouble()
            if (bInput == 0.0) {
                Toast.makeText(
                    context,
                    "Can't divided by 0.Please re-enter number b",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                caculator() { a, b -> a / b }
            }
        }
    }

    fun caculator( caculate: (Double, Double) -> Double) {
        val aInput = binding.edtNhapA.text.toString()
        val bInput = binding.edtNhapB.text.toString()
        val a = checkInput(aInput).toDouble()
        val b = checkInput(bInput).toDouble()
        val ketqua = caculate(a, b)
        val bundle = bundleOf("message" to ketqua.toString())
        findNavController().navigate(R.id.action_congtruFragment_to_ketquaFragment, bundle)
    }
}