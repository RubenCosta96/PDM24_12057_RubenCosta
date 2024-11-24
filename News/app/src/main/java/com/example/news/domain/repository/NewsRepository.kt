package com.example.news.domain.repository

import com.example.news.domain.model.News
import com.example.news.domain.model.Result

interface NewsRepository {
    suspend fun getNews(): List<News>
    suspend fun getNewsDetail(newsId: String): Result
}