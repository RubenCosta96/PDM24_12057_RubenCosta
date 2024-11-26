package com.example.news.presentation.news_list_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import com.example.news.presentation.news_list_viewmodels.NewsDetailViewModel

@Composable
fun NewsDetailScreen(
    viewModel: NewsDetailViewModel,
    newsUri: String,
    onBack: () -> Unit
){
    LaunchedEffect(newsUri) {
        viewModel.fetchNewsDetail(newsUri)
    }

    val newsDetail by viewModel.newsDetail.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
        }

        newsDetail?.let { detail ->
            Text(
                text = detail.snippet,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = detail.leadParagraph,
                style = MaterialTheme.typography.bodyLarge
            )
        } ?: CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
    }
} 