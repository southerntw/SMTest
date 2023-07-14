package com.example.kmtest.ui.screen.third

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.compose.items
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.kmtest.data.remote.DataItem
import com.example.kmtest.ui.components.UserComponent
import com.example.kmtest.ui.navigation.TopBar
import com.example.kmtest.ui.viewmodel.AppViewModel

@Composable
fun ThirdScreen(
    modifier: Modifier = Modifier,
    viewModel: AppViewModel,
    onBackClicked: () -> Unit
) {
    ThirdContent(
        onBackClicked = onBackClicked, users = viewModel.getUsers().collectAsLazyPagingItems(),
        viewModel = viewModel, modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirdContent(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
    viewModel: AppViewModel,
    users: LazyPagingItems<DataItem>
) {
    val choosen by viewModel.choosenName
    val padval = WindowInsets.systemBars.asPaddingValues()
    val top = padval.calculateTopPadding()

    Scaffold(
        topBar = {
            TopBar(onBackClicked = onBackClicked, screen = "Third Screen")
        }, modifier = modifier.padding(top = top))
    { paddingValues ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(paddingValues)
                .padding(top = 15.dp)
                .fillMaxSize()
        ) {
            items(items = users, key = { it.email }) { user ->
                if (user != null) {
                    UserComponent(photoUrl = user.avatar, firstName =  user.firstName,
                        lastName = user.lastName, email = user.email,
                        modifier = modifier.clickable {
                            viewModel.setChoosen("${user.firstName} ${user.lastName}")
                            Log.d("ThirdScreen", choosen)
                        })
                }
            }

            // Add pullrefresh here
//            item {
//                PullRefreshIndicator(
//                    state = users.loadState,
//                    onRefresh = {
//                        viewModel.refreshUsers()
//                    }
//                )
//            }


            when (users.loadState.refresh) {
                is LoadState.Error -> {
                    item {

                    }
                }

                is LoadState.Loading -> {
                    item {
                        Column(
                            modifier = Modifier
                                .fillParentMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(8.dp),
                                text = "Loading"
                            )

                            CircularProgressIndicator(color = Color.Black)
                        }
                    }
                }

                is LoadState.NotLoading -> {
                    if (users.itemCount == 0) {
                        item {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 50.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                            ) {
                                Text(text = "This page is empty!")
                            }
                        }
                    }
                }

                else -> {}
            }
            when (users.loadState.append) {
                is LoadState.Error -> {
                    item {

                    }
                }

                is LoadState.Loading -> {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Text(text = "Loading")

                            CircularProgressIndicator(color = Color.Black)
                        }
                    }
                }
                else -> {}
            }
        }
    }
}