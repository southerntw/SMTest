package com.example.kmtest.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kmtest.R
import com.example.kmtest.ui.screen.second.SecondContent
import com.example.kmtest.ui.theme.KMTestTheme
import com.example.kmtest.ui.theme.KmBlack
import com.example.kmtest.ui.theme.KmGray
import com.example.kmtest.ui.theme.KmWhite

@Composable
fun UserComponent(
    modifier: Modifier = Modifier,
    photoUrl: String,
    firstName: String,
    lastName: String,
    email: String
) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .height(80.dp)
            .padding(horizontal = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = modifier
                .fillMaxSize()
                .background(color = KmWhite)
                .drawBehind {
                val borderSize = .5.dp.toPx()
                val y = size.height - borderSize / 2
                drawLine(
                    color = KmGray,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = borderSize
                )
            }
        ) {
            AsyncImage(
                model = photoUrl,
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 18.dp, end = 20.dp)
                    .height(49.dp)
                    .width(49.dp)
                    .clip(CircleShape)
            )

            Column(
                modifier = modifier.padding()
            ) {
                Text(text = "$firstName $lastName",
                    style = MaterialTheme.typography.bodyLarge,
                    color = KmBlack,
                    fontWeight = FontWeight.SemiBold
                )
                Text(text = email.uppercase(), style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondPreview() {
    KMTestTheme {
//        UserComponent2(photoUrl = "", firstName = "Firstname", lastName = "Lastname", email = "email@email.com")
    }
}