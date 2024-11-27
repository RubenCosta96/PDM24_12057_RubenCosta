package com.example.news.data.remote.api

import com.example.news.data.remote.model.NewsDetailDto
import com.example.news.data.remote.model.NewsDetailListDto
import com.example.news.data.remote.model.NewsDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

object RetrofitInstance {
    val api: NewsApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }
}

interface NewsApi{
    @GET("topstories/v2/home.json?api-key=2lAGzYgTlUGjG3dJQbscMVQFmOkBAH9b")
    suspend fun getNews(): NewsDto

    //@GET("topstories/v2/home.json?api-key=2lAGzYgTlUGjG3dJQbscMVQFmOkBAH9b") // Completar
    @GET("search/v2/articlesearch.json?&api-key=2lAGzYgTlUGjG3dJQbscMVQFmOkBAH9b")
    suspend fun getNewsDetailList(): NewsDetailListDto

    @GET("search/v2/articlesearch.json?&api-key=2lAGzYgTlUGjG3dJQbscMVQFmOkBAH9b")
    suspend fun getNewsDetail(@Query("fq") fq: String): NewsDetailDto
}