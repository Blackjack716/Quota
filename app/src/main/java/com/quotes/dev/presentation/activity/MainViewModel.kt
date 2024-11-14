package com.quotes.dev.presentation.activity

import androidx.lifecycle.ViewModel
import com.quotes.dev.domain.features.GetRandomQuoteByCategoryUseCase
import com.quotes.dev.domain.features.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase,
    private val getRandomQuoteByCategoryUseCase: GetRandomQuoteByCategoryUseCase
) : ViewModel()  {

}