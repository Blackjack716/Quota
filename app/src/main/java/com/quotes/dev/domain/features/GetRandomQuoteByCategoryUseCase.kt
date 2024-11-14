package com.quotes.dev.domain.features

import com.quotes.dev.domain.model.Quote
import com.quotes.dev.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRandomQuoteByCategoryUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {
    suspend fun execute(category: String): Flow<Quote> {
        return quoteRepository.getRandomQuoteByCategory(category)
    }
}