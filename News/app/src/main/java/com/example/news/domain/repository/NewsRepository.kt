package com.example.news.domain.repository

import android.util.Log
import com.example.news.domain.model.NewsDetail
import com.example.news.domain.model.Result

interface NewsRepository {
    suspend fun getNews(): List<Result>
    suspend fun getNewsDetail(newsUri: String): NewsDetail
}

class GetNewsUseCase(private val repository: NewsRepository) {
    suspend operator fun invoke(): List<Result>{
        return repository.getNews()
    }
}

class GetNewsDetailUseCase(private val repository: NewsRepository) {
    suspend operator fun invoke(newsUri: String): NewsDetail {
        return repository.getNewsDetail(newsUri)
    }
}
