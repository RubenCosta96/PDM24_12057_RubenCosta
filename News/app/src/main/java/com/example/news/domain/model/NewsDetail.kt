package com.example.news.domain.model

import com.google.gson.annotations.SerializedName

data class NewsDetail(
  @SerializedName("lead_paragraph")
  val leadParagraph: String,
  val snippet: String,
  val uri: String,
)