package com.example.news.presentation.news_list_viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.data.remote.api.RetrofitInstance
import com.example.news.data.repository.NewsRepositoryImpl
import com.example.news.domain.model.NewsDetail
import com.example.news.domain.repository.GetNewsDetailListUseCase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NewsDetailListViewModel : ViewModel(){

    private val api = RetrofitInstance.api
    private val repository = NewsRepositoryImpl(api)
    private val getNewsDetailListUseCase = GetNewsDetailListUseCase(repository)

    val newsDetailList = MutableStateFlow<List<NewsDetail>>(emptyList())

    fun fetchNewsDetailList(){
        viewModelScope.launch {
            try {
                newsDetailList.value = getNewsDetailListUseCase()
            } catch (e: Exception){
                newsDetailList.value = emptyList()
            }
        }
    }
}