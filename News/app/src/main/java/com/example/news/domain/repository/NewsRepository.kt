package com.example.news.domain.repository

import com.example.news.domain.model.Result

interface NewsRepository {
    suspend fun getNews(): List<Result>
    suspend fun getNewsDetail(newsId: String): Result
}

class GetNewsUseCase(private val repository: NewsRepository) {
    suspend operator fun invoke(): List<Result>{
        return repository.getNews()
    }
}

class GetNewsDetailUseCase(private val repository: NewsRepository) {
    suspend operator fun invoke(newsId: String): Result{
        return repository.getNewsDetail(newsId)
    }
}
