package com.example.coinpaprikaapi.presentation.coin_list_screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.coinpaprikaapi.domain.model.Coin
import com.example.coinpaprikaapi.presentation.coin_list_viewmodels.CoinListViewModel

@Composable
fun CoinListScreen(
    viewModel: CoinListViewModel,
    onCoinSelected: (String) -> Unit
) {
    val coins by viewModel.coins.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCoins()
    }

    LazyColumn {
        items(coins) { coin ->
            CoinItem(coin = coin) {
                onCoinSelected(it)
            }
        }
    }
}

@Composable
fun CoinItem(coin: Coin, onClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick(coin.id) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = coin.name,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = coin.symbol,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.End,
            modifier = Modifier.padding(end = 8.dp)
        )
    }
}
