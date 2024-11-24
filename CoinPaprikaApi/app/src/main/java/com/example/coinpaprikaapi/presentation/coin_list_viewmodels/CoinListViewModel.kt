package com.example.coinpaprikaapi.presentation.coin_list_viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinpaprikaapi.data.remote.api.RetrofitInstance
import com.example.coinpaprikaapi.data.repository.CoinRepositoryImpl
import com.example.coinpaprikaapi.domain.model.Coin
import com.example.coinpaprikaapi.domain.repository.GetCoinsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CoinListViewModel : ViewModel(){

    private val api = RetrofitInstance.api
    private val repository = CoinRepositoryImpl(api)
    private val getCoinsUseCase = GetCoinsUseCase(repository)

    val coins = MutableStateFlow<List<Coin>>(emptyList())

    fun fetchCoins(){
        viewModelScope.launch {
            try {
                coins.value = getCoinsUseCase()
            } catch(e: Exception){
                coins.value = emptyList()
            }
        }
    }

}