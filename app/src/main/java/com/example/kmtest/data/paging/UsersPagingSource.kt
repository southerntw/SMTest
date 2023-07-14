package com.example.kmtest.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kmtest.data.remote.ApiService
import com.example.kmtest.data.remote.DataItem

class UsersPagingSource(private val apiService: ApiService) : PagingSource<Int, DataItem>() {
    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }

    override fun getRefreshKey(state: PagingState<Int, DataItem>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        return try {
            val position = params.key ?: INITIAL_PAGE_INDEX
            val responseData =
                apiService.getUsers(page = position, size = params.loadSize)

            LoadResult.Page(
                data = responseData.data,
                prevKey = if (position == INITIAL_PAGE_INDEX) null else position - 1,
                nextKey = if (responseData.data.isEmpty()) null else position + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}