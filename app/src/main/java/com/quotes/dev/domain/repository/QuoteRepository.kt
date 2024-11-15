package com.quotes.dev.domain.repository

import com.quotes.dev.domain.model.QuoteData

interface QuoteRepository {
    suspend fun getRandomQuote(): QuoteData
    suspend fun getRandomQuoteByCategory(category: String): QuoteData
}