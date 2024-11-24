package com.example.news.presentation.news_list_screens

import android.util.Log
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
            NewsItem(newsItem = newsItem) {
                onNewsSelected(it)
            }
        }
    }
}

@Composable
fun NewsItem(newsItem: Result, onClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick(newsItem.url) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = newsItem.title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = newsItem.section,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.End,
            modifier = Modifier.padding(end = 8.dp)
        )
    }
}