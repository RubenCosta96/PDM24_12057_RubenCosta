package com.example.news.domain.model


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("response")
    val response: NewsDetailList,
    @SerializedName("status")
    val status: String
)