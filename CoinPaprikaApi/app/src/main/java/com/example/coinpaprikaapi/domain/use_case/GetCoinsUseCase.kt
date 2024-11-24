package com.example.coinpaprikaapi.domain.use_case

import com.example.coinpaprikaapi.domain.model.Coin
import com.example.coinpaprikaapi.domain.repository.CoinRepository

class GetCoinsUseCase(private val repository: CoinRepository) {
    suspend operator fun invoke(): List<Coin>{
        return repository.getCoins()
    }
}