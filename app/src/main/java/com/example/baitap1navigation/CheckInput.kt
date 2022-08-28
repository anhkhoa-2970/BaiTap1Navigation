package com.example.baitap1navigation

interface CheckInput {
    fun checkInput(string : String) : String{
        val a = string.indexOf(",")
        var newString : String = string
        if(a != -1){
            newString = string.replace(",",".")
        }

        return newString
    }
}