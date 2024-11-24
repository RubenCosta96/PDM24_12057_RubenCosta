package com.example.news.domain.model

data class Result(
    val created_date: String,
    val multimedia: List<Multimedia>,
    val published_date: String,
    val section: String,
    val short_url: String,
    val subsection: String,
    val title: String,
    val uri: String,
    val url: String
)