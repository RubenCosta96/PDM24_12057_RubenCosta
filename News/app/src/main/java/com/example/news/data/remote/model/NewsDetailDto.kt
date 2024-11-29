package com.example.news.data.remote.model

import android.util.Log
import com.example.news.domain.model.NewsDetail
import com.google.gson.annotations.SerializedName

data class NewsDetailDto(
    @SerializedName("lead_paragraph")
    val leadParagraph: String,
    @SerializedName("snippet")
    val snippet: String,
    @SerializedName("uri")
    val uri: String,
){
    fun toNewsDetail(): NewsDetail {
        return NewsDetail(leadParagraph = leadParagraph, snippet = snippet, uri = uri)
    }
}