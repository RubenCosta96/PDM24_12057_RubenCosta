package com.example.coinpaprikaapi.presentation.coin_list_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coinpaprikaapi.presentation.coin_list_viewmodels.CoinDetailViewModel

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel,
    coinId: String,
    onBack: () -> Unit
) {
    LaunchedEffect(coinId) {
        viewModel.fetchCoinDetail(coinId)
    }

    val coinDetail by viewModel.coinDetail.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        IconButton(onClick = onBack) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }

        coinDetail?.let { detail ->
            Text(
                text = detail.name,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = detail.description,
                style = MaterialTheme.typography.bodyLarge
            )
        } ?: CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}
