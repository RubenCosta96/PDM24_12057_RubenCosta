package com.example.coinpaprikaapi.presentation.coin_list_viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinpaprikaapi.data.remote.api.RetrofitInstance
import com.example.coinpaprikaapi.data.repository.CoinRepositoryImpl
import com.example.coinpaprikaapi.domain.model.CoinDetail
import com.example.coinpaprikaapi.domain.repository.GetCoinDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CoinDetailViewModel: ViewModel() {

    private val api = RetrofitInstance.api
    private val repository = CoinRepositoryImpl(api)
    private val getCoinDetailUseCase = GetCoinDetailUseCase(repository)

    val coinDetail = MutableStateFlow<CoinDetail?>(null)

    fun fetchCoinDetail(coinId:String){
        viewModelScope.launch{
            try {
                coinDetail.value = getCoinDetailUseCase(coinId)
            }catch(e:Exception){
                coinDetail.value = null
            }
        }
    }
}