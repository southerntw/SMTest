package com.example.kmtest.data.repository

import android.content.Context
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.kmtest.data.paging.UsersPagingSource
import com.example.kmtest.data.remote.ApiService
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService,
    @ApplicationContext private val context: Context
) {
    fun getUsers() = Pager(
        config = PagingConfig(
            pageSize = 30,
        ),
        pagingSourceFactory = {
            UsersPagingSource(
                apiService,
            )
        }
    ).flow
}