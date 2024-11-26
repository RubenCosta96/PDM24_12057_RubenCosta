package com.example.news.presentation.news_list_viewmodels

import android.util.Log
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

    val newsDetail = MutableStateFlow<NewsDetail?>(null)

    fun fetchNewsDetail(newsUri: String) {
        viewModelScope.launch {
            try {
                Log.d("Dados ViewModel", "Mensagem $newsUri") // Uri está correto
                newsDetail.value = getNewsDetailUseCase(newsUri)
            } catch (e: Exception) {
                Log.e("Dados Erro ViewModel", "Erro ao buscar dados", e)
                newsDetail.value = null
            }
        }
    }
}