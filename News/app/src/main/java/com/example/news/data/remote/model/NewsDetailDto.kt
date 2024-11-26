package com.example.news.data.remote.model

import android.util.Log
import com.example.news.domain.model.NewsDetail
import com.google.gson.annotations.SerializedName

data class NewsDetailDto(
    @SerializedName("lead_paragraph")
    val leadParagraph: String,
    val snippet: String,
    val uri: String,
) {
    fun toNewsDetail(): NewsDetail{
        if (leadParagraph.isNullOrEmpty()) {
            Log.e("Dados Dto", "leadParagraph está vazio ou nulo")
        }

        return NewsDetail(leadParagraph = leadParagraph, snippet = snippet, uri = uri)
    }
}