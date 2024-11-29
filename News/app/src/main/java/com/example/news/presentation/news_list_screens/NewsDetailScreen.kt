package com.example.news.presentation.news_list_screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
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

    if (newsDetail != null) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = newsDetail!!.snippet, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = newsDetail!!.leadParagraph, style = MaterialTheme.typography.bodyLarge)
            Button(onClick = onBack) {
                Text(text = "Voltar")
            }
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}