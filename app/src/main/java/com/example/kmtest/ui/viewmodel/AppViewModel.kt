package com.example.kmtest.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.kmtest.data.remote.DataItem
import com.example.kmtest.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun getUsers(): Flow<PagingData<DataItem>> =
        repository.getUsers(
        ).cachedIn(viewModelScope)

    private val _username = mutableStateOf("")
    val username: State<String> get() = _username

    private val _choosenName = mutableStateOf("")
    val choosenName: State<String> get() = _choosenName

    private val _palindrome = mutableStateOf("")
    val palindrome: State<String> get() = _palindrome

    fun setUsername(name: String) {
        _username.value = name
    }

    fun setChoosen(choosen: String) {
        _choosenName.value = choosen
    }

    fun setPalindrome(word: String) {
        _palindrome.value = word
    }
}