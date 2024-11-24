package com.example.coinpaprikaapi.domain.repository

import com.example.coinpaprikaapi.domain.model.Coin
import com.example.coinpaprikaapi.domain.model.CoinDetail

interface CoinRepository {
    suspend fun getCoins(): List<Coin>
    suspend fun getCoinDetail(coinId:String):CoinDetail
}

class GetCoinsUseCase(private val repository: CoinRepository) {
    suspend operator fun invoke(): List<Coin>{
        return repository.getCoins()
    }
}

class GetCoinDetailUseCase(private val repository: CoinRepository){
    suspend operator fun invoke(coinId: String): CoinDetail{
        return repository.getCoinDetail(coinId)
    }
}