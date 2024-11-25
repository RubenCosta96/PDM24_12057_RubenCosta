package com.example.news.data.repository

import com.example.news.data.remote.api.NewsApi
import com.example.news.domain.model.Result
import com.example.news.domain.repository.NewsRepository

class NewsRepositoryImpl(private val api: NewsApi): NewsRepository {
    override suspend fun getNews(): List<Result>{
        return api.getNews().results.map { it.toNews() }
    }

    override suspend fun getNewsDetail(newsId: String): Result {
        return api.getNewsDetail(newsId).toNews()
    }
}