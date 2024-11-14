package com.quotes.dev.data.remote

import com.quotes.dev.domain.model.Quote
import com.quotes.dev.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor() : QuoteRepository {
    override suspend fun getRandomQuote(): Flow<Quote> {
        TODO("Not yet implemented")
    }

    override suspend fun getRandomQuoteByCategory(category: String): Flow<Quote> {
        TODO("Not yet implemented")
    }
}