package com.example.news.data.remote.model


import com.google.gson.annotations.SerializedName

data class ResponseDto(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("response")
    val response: NewsDetailListDto,
    @SerializedName("status")
    val status: String
)