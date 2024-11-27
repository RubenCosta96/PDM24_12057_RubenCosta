package com.example.news

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.news.presentation.news_list_screens.NewsDetailScreen
import com.example.news.presentation.news_list_screens.NewsListScreen
import com.example.news.presentation.news_list_viewmodels.NewsDetailViewModel
import com.example.news.presentation.news_list_viewmodels.NewsListViewModel

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
    var selectedNewsUri by remember { mutableStateOf<String?>(null) }

    if (selectedNewsUri == null) {
        val newsListViewModel: NewsListViewModel = viewModel()
        NewsListScreen(newsListViewModel) { newsUri ->
            selectedNewsUri = newsUri
        }
    } else {
        val newsDetailViewModel: NewsDetailViewModel = viewModel()
        NewsDetailScreen(newsDetailViewModel, selectedNewsUri!!) {
            selectedNewsUri = null
        }
    }
}
