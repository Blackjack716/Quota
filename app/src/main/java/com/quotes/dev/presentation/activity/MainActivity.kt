package com.quotes.dev.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.quotes.dev.presentation.theme.QuoteOfTheDayTheme
import com.quotes.dev.presentation.ui.QuoteHomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var quoteState by remember {
                mutableStateOf(mainViewModel.quote.value)
            }

            LaunchedEffect(Unit) {
                mainViewModel.quote.collect {
                    quoteState = it
                }
            }

            QuoteOfTheDayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuoteHomeScreen(
                        innerPadding,
                        quoteState,
                        onAction = mainViewModel::onAction
                    )
                }
            }
        }
    }
}
