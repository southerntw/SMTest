package com.example.kmtest.ui.screen.second

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kmtest.ui.navigation.TopBar
import com.example.kmtest.ui.theme.KMTestTheme
import com.example.kmtest.ui.viewmodel.AppViewModel

@Composable
fun SecondScreen(modifier: Modifier = Modifier,
                 onChooseClicked: () -> Unit,
                 onBackClicked: () -> Unit,
                 viewModel: AppViewModel
) {
    val username by viewModel.username
    val choosenName by viewModel.choosenName

    SecondContent(username = username, choosenName = choosenName, onChooseClicked = onChooseClicked,
        onBackClicked = onBackClicked)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondContent(
    modifier: Modifier = Modifier,
    username: String,
    choosenName: String,
    onChooseClicked: () -> Unit,
    onBackClicked: () -> Unit
) {
    val padval = WindowInsets.systemBars.asPaddingValues()
    val top = padval.calculateTopPadding()

    Scaffold(
        topBar = {
            TopBar(onBackClicked = onBackClicked, screen = "Second Screen")
        }, modifier = modifier.padding(top = top))
    { paddingValues ->

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp, vertical = 25.dp)
        ) {
            Column(modifier.align(Alignment.Start)) {
                Text(
                    text = "Welcome",
                    style = MaterialTheme.typography.bodySmall
                )

                Text(
                    text = username,
                    style = MaterialTheme.typography.titleMedium
                )
            }


            Spacer(modifier.weight(1f))

            Text(
                text = choosenName.ifEmpty {
                    "Selected User Name"
                },
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier.weight(1f))

            Button(
                onClick = onChooseClicked,
                shape = RoundedCornerShape(16.dp),
                modifier = modifier
                    .width(310.dp)
                    .height(47.dp)
            ) {
                Text(text = "Choose a User", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondPreview() {
    KMTestTheme {
        SecondContent(username = "", choosenName = "", onChooseClicked = {}) {
            
        }
    }
}