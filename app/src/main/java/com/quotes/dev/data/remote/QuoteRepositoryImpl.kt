package com.quotes.dev.data.remote

import com.quotes.dev.domain.model.Quote
import com.quotes.dev.domain.repository.QuoteRepository
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor() : QuoteRepository {
    override suspend fun getRandomQuote(): Quote {
        TODO("Not yet implemented")
    }

    override suspend fun getRandomQuoteByCategory(category: String): Quote {
        TODO("Not yet implemented")
    }
}