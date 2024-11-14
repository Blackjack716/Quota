package com.quotes.dev.presentation.activity

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quotes.dev.domain.features.GetRandomQuoteByCategoryUseCase
import com.quotes.dev.domain.features.GetRandomQuoteUseCase
import com.quotes.dev.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase,
    private val getRandomQuoteByCategoryUseCase: GetRandomQuoteByCategoryUseCase
) : ViewModel()  {

    private val _quote = MutableStateFlow<Quote?>(null)
    val quote = _quote.asStateFlow()

    fun getRandomQuote() {
        viewModelScope.launch {
            getRandomQuoteUseCase.execute().collect {
                _quote.emit(it)
            }
        }
    }

    fun getRandomQuoteByCategory(category: String) {
        viewModelScope.launch {
            getRandomQuoteByCategoryUseCase.execute(category).collect {
                _quote.emit(it)
            }
        }
    }
}