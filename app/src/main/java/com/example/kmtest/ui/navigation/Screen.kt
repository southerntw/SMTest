package com.example.kmtest.ui.navigation

sealed class Screen(val route: String) {
    object First : Screen("first")
    object Second : Screen("second")
    object Third : Screen("third")
}