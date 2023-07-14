package com.example.kmtest.ui.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kmtest.R
import com.example.kmtest.ui.components.UserComponent
import com.example.kmtest.ui.theme.KMTestTheme
import com.example.kmtest.ui.theme.KmGray

@Composable
fun TopBar(modifier: Modifier = Modifier, onBackClicked: () -> Unit, screen: String) {
    Row(modifier = modifier
        .fillMaxWidth()
        .drawBehind {
            val borderSize = .5.dp.toPx()
            val y = size.height - borderSize / 2
            drawLine(
                color = KmGray,
                start = Offset(0f, y),
                end = Offset(size.width, y),
                strokeWidth = borderSize
            )
        }) {
        Button(onClick = onBackClicked,
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            contentPadding = PaddingValues(1.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.button_back),
                contentDescription = "Back",
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
                    .background(color = Color.Transparent)
                    .align(Alignment.CenterVertically)
            )
        }
        Spacer(modifier.weight(.5f))
            Text(text = screen,
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.align(Alignment.CenterVertically)
            )
        Spacer(modifier.weight(1f))

    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    KMTestTheme {
        TopBar(onBackClicked = {}, screen = "Second Screen")
    }
}