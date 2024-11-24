package com.example.news.data.remote.api

import com.example.news.data.remote.model.ResultDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object RetrofitInstance {
    val api: NewsApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/topstories/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }
}

interface NewsApi{
    @GET("v2/home.json?api-key=2lAGzYgTlUGjG3dJQbscMVQFmOkBAH9b")
    suspend fun getNews(): List<ResultDto>

    @GET("v2/{section}.json?api-key=2lAGzYgTlUGjG3dJQbscMVQFmOkBAH9b")
    suspend fun getNewsDetail(@Path("id") newsId: String): ResultDto
}