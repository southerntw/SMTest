package com.example.kmtest.ui.screen.first

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kmtest.ui.viewmodel.AppViewModel
import com.example.kmtest.utils.isPalindrome
import com.example.kmtest.R
import com.example.kmtest.ui.theme.KmBlack
import com.example.kmtest.ui.theme.KmGray

@Composable
fun FirstScreen(modifier: Modifier = Modifier,
                viewModel: AppViewModel,
                onNextClicked: () -> Unit
) {
    val username by viewModel.username
    val palindrome by viewModel.palindrome

    val showDialog = remember { mutableStateOf(false) }

    DialogPopUp(popupControl = showDialog, palindrome)

    FirstContent(
        name = username,
        palindrome = palindrome,
        onCheckClicked = { showDialog.value = true },
        onNextClicked = onNextClicked,
        onNameChanged = viewModel::setUsername,
        onPalindromeChanged = viewModel::setPalindrome,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstContent(
    modifier: Modifier = Modifier,
    name: String,
    palindrome: String,
    onCheckClicked: () -> Unit,
    onNextClicked: () -> Unit,
    onNameChanged: (String) -> Unit,
    onPalindromeChanged: (String) -> Unit
) {
    Column(modifier = modifier
        .fillMaxSize()
        .paint(painterResource(id = R.drawable.bg), contentScale = ContentScale.FillBounds),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        BasicTextField(
//            value = name,
//            onValueChange = onNameChanged,
//            shape = RoundedCornerShape(12.dp),
//            maxLines = 1,
//            singleLine = true,
//            modifier = Modifier
//                .width(310.dp)
//                .height(47.dp)
//                .padding(0.dp)
//                .clip(shape = RoundedCornerShape(16.dp))
//        )

        BasicTextField(
            value = name,
            singleLine = true,
            onValueChange = onNameChanged,
            textStyle = LocalTextStyle.current.copy(
                color = KmBlack,
                fontSize = 16.sp,
                lineHeight = 24.sp
            ),
            decorationBox = { innerTextField ->
                Row(
                   modifier.padding(start = 20.dp),
                   verticalAlignment = Alignment.CenterVertically
                ) {
                    val placeholderText = "Name"
                    Box(Modifier.weight(1f)) {
                        if (name.isEmpty()) Text(
                            placeholderText,
                            style = LocalTextStyle.current.copy(
                                color = KmGray,
                                fontSize = 16.sp,
                                lineHeight = 24.sp
                            )
                        )
                        innerTextField()
                    }
                }
            },
            modifier = Modifier
                .background(
                    MaterialTheme.colorScheme.surface,
                    RoundedCornerShape(12.dp),
                )
                .width(310.dp)
                .height(47.dp)
        )
        
        Spacer(modifier = modifier.height(15.dp))

        BasicTextField(
            value = palindrome,
            singleLine = true,
            onValueChange = onPalindromeChanged,
            textStyle = LocalTextStyle.current.copy(
                color = KmBlack,
                fontSize = 16.sp,
                lineHeight = 24.sp
            ),
            decorationBox = { innerTextField ->
                Row(
                    modifier.padding(start = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val placeholderText = "Palindrome"
                    Box(Modifier.weight(1f)) {
                        if (palindrome.isEmpty()) Text(
                            placeholderText,
                            style = LocalTextStyle.current.copy(
                                color = KmGray,
                                fontSize = 16.sp,
                                lineHeight = 24.sp
                            )
                        )
                        innerTextField()
                    }
                }
            },
            modifier = Modifier
                .background(
                    MaterialTheme.colorScheme.surface,
                    RoundedCornerShape(12.dp),
                )
                .width(310.dp)
                .height(47.dp)
        )

        Spacer(modifier = modifier.height(45.dp))

        Button(onClick = onCheckClicked,
            enabled = palindrome.isNotEmpty(),
            shape = RoundedCornerShape(16.dp),
            modifier = modifier
                .padding(bottom = 15.dp)
                .width(310.dp)
                .height(47.dp)
        ) {
            Text(text = "CHECK", color = Color.White)
        }
        
        Button(onClick = onNextClicked,
            enabled = name.isNotEmpty(),
            shape = RoundedCornerShape(16.dp),
            modifier = modifier
                .padding(bottom = 15.dp)
                .width(310.dp)
                .height(47.dp)
        ) {
            Text(text = "NEXT", color = Color.White)
        }
    }
}

@Composable
fun DialogPopUp(popupControl: MutableState<Boolean>, palindrome: String) {
    if (popupControl.value) {
        val checkPalindrome = if (isPalindrome(palindrome)) {
            "isPalindrome"
        } else {
            "not palindrome"
        }

        AlertDialog(
            onDismissRequest = { popupControl.value = false },
            title = { Text(palindrome) },
            text = { Text(checkPalindrome) },
            confirmButton = {
                TextButton(onClick = { popupControl.value = false }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { popupControl.value = false }) {
                    Text("Cancel".uppercase())
                }
            },
        )
    }
}