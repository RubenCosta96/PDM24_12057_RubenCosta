package com.example.news.data.repository

import android.util.Log
import com.example.news.data.remote.api.NewsApi
import com.example.news.domain.model.NewsDetail
import com.example.news.domain.model.Result
import com.example.news.domain.repository.NewsRepository

class NewsRepositoryImpl(private val api: NewsApi): NewsRepository {
    override suspend fun getNews(): List<Result>{
        return api.getNews().results.map { it.toNews() }
    }

    override suspend fun getNewsDetailList(): List<NewsDetail> {
        Log.d("Resposta", "Chamando getNewsDetailList")
        val response = api.getNewsDetailList()
        Log.d("Resposta", "Resposta da API: ${response.docs}")
        return response.docs.map { it.toNewsDetail() }
//        return api.getNewsDetailList().docs.map {it.toNewsDetail()}
    }

    override suspend fun getNewsDetail(newsUri: String): NewsDetail {
        val fq = "uri:\"$newsUri\""
        return api.getNewsDetail(fq).toNewsDetail()
    }
}