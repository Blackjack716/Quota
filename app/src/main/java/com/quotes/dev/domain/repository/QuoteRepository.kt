package com.quotes.dev.domain.repository

import com.quotes.dev.domain.model.Quote
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    suspend fun getRandomQuote(): Flow<Quote>
    suspend fun getRandomQuoteByCategory(category: String): Flow<Quote>
}