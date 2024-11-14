package com.quotes.dev.domain.features

import com.quotes.dev.domain.model.Quote
import com.quotes.dev.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {
    suspend fun execute(): Flow<Quote> {
        return quoteRepository.getRandomQuote()
    }
}