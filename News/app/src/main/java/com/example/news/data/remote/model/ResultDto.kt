package com.example.news.data.remote.model

import com.example.news.domain.model.Result

data class ResultDto(
    val created_date: String,
    val published_date: String,
    val section: String,
    val short_url: String,
    val title: String,
    val uri: String
){
    fun toNews(): Result{
        return Result(created_date = created_date, published_date = published_date, section = section, short_url=short_url,title=title,uri=uri)
    }
}