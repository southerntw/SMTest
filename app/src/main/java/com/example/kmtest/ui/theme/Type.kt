package com.example.kmtest.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.kmtest.R



val poppins = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_medium, weight = FontWeight.Medium),
    Font(R.font.poppins_semibold, weight = FontWeight.SemiBold),
    Font(R.font.poppins_bold, weight = FontWeight.Bold),
    Font(R.font.poppins_light, weight = FontWeight.Light),
    Font(R.font.poppins_thin, weight = FontWeight.Thin),
    Font(R.font.poppins_italic, weight = FontWeight.Normal, style = FontStyle.Italic)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = poppins,
        fontSize = 16.sp,
        lineHeight = 27.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = poppins,
        fontSize = 14.sp,
        lineHeight = 24.sp
    ),

    bodySmall = TextStyle(
        fontFamily = poppins,
        fontSize = 12.sp,
        lineHeight = 15.sp
    ),

    titleLarge = TextStyle(
        fontFamily = poppins,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.Bold
    ),

    titleMedium = TextStyle(
        fontFamily = poppins,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Bold
    ),

    titleSmall = TextStyle(
        fontFamily = poppins,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Bold
    ),

    headlineSmall = TextStyle(
        fontFamily = poppins,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        fontWeight = FontWeight.Bold
    ),

    labelSmall = TextStyle(
        fontFamily = poppins,
        fontSize = 10.sp,
        lineHeight = 16.sp
    )
)