package com.example.baitap1navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.baitap1navigation.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar = binding.toolbar3
     //   val toolbarTitle = binding.toolbarTitle
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Toán học"

    }
    fun checkInput(string : String) : String{
        val a = string.indexOf(",")
        var newString : String = string
        if(a != -1){
            newString = string.replace(",",".")
        }

        return newString
    }
}
