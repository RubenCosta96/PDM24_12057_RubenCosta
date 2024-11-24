package com.example.coinpaprikaapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coinpaprikaapi.presentation.coin_list_screens.CoinDetailScreen
import com.example.coinpaprikaapi.presentation.coin_list_screens.CoinListScreen
import com.example.coinpaprikaapi.presentation.coin_list_viewmodels.CoinDetailViewModel
import com.example.coinpaprikaapi.presentation.coin_list_viewmodels.CoinListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){
    var selectedCoinId by remember { mutableStateOf<String?>(null)}

    Box(
        modifier = Modifier.padding(20.dp)
    ){
        if(selectedCoinId == null){
            val coinListViewModel: CoinListViewModel = viewModel()
            CoinListScreen(coinListViewModel) {coinId ->
                selectedCoinId = coinId
            }
        }else{
            val coinDetailViewModel: CoinDetailViewModel = viewModel()
            CoinDetailScreen(coinDetailViewModel, selectedCoinId!!){
                selectedCoinId = null
            }
        }
    }
}
