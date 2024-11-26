package com.example.news.presentation.news_list_viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.data.remote.api.RetrofitInstance
import com.example.news.data.repository.NewsRepositoryImpl
import com.example.news.domain.model.NewsDetail
import com.example.news.domain.repository.GetNewsDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NewsDetailViewModel : ViewModel() {

    private val api = RetrofitInstance.api
    private val repository = NewsRepositoryImpl(api)
    private val getNewsDetailUseCase = GetNewsDetailUseCase(repository)

    val newsDetail = MutableStateFlow<List<NewsDetail>>(emptyList())

    fun fetchNewsDetail() {
        viewModelScope.launch {
            try {
                newsDetail.value = getNewsDetailUseCase()
            } catch (e: Exception) {
                newsDetail.value = emptyList()
            }
        }
    }
}