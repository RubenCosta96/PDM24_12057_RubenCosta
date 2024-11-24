package com.example.news.domain.model

data class Result(
    val created_date: String,
    val published_date: String,
    val section: String,
    val short_url: String,
    val title: String,
    val url: String
)