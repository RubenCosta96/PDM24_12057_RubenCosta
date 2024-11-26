package com.example.news.data.remote.model

import com.example.news.domain.model.NewsDetail

data class NewsDetailDto(
    val title: String,
    val caption: String
) {
    fun toNewsDetail(): NewsDetail{
        return NewsDetail(title = title, caption = caption)
    }
}