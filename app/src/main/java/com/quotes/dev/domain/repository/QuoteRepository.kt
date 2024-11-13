package com.quotes.dev.domain.repository

import com.quotes.dev.domain.model.Quote

interface QuoteRepository {
    suspend fun getRandomQuote(): Quote
    suspend fun getRandomQuoteByCategory(category: String): Quote
}