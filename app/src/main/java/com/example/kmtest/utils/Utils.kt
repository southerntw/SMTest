package com.example.kmtest.utils

fun isPalindrome(inputStr: String): Boolean {
    val sb = StringBuilder(inputStr)
    val reverseStr = sb.reverse().toString()
    return inputStr.equals(reverseStr, ignoreCase = true)
}