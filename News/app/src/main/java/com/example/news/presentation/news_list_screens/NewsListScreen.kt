package com.example.news.presentation.news_list_screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.news.presentation.news_list_viewmodels.NewsListViewModel
import com.example.news.domain.model.Result

@Composable
fun NewsListScreen(
    viewModel: NewsListViewModel,
    onNewsSelected: (String) -> Unit
) {
    val newsList by viewModel.news.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchNews()
    }

    LazyColumn {
        items(newsList) { newsItem ->
            NewsItem(newsItem) {
                onNewsSelected(newsItem.uri)
            }
        }
    }
}

@Composable
fun NewsItem(news: Result, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = news.title, style = MaterialTheme.typography.headlineLarge)
            Text(text = news.section, style = MaterialTheme.typography.bodyMedium)
        }
    }
}