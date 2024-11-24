package com.example.coinpaprikaapi.data.repository

import com.example.coinpaprikaapi.data.remote.api.CoinPaprikaApi
import com.example.coinpaprikaapi.domain.model.Coin
import com.example.coinpaprikaapi.domain.model.CoinDetail
import com.example.coinpaprikaapi.domain.repository.CoinRepository

class CoinRepositoryImpl(private val api: CoinPaprikaApi) : CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        return api.getCoins().map {it.toCoin()}
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetail {
        return api.getCoinDetail(coinId).toCoinDetail()
    }
}