package com.quotes.dev.domain.features

import com.quotes.dev.domain.model.Category
import com.quotes.dev.domain.model.CategoryList
import com.quotes.dev.domain.model.QuoteData
import com.quotes.dev.domain.repository.QuoteRepository
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
) {
    suspend fun execute(category: Category): QuoteData {
        return if (category == CategoryList().first()) {
            quoteRepository.getRandomQuote()
        } else {
            quoteRepository.getRandomQuoteByCategory(category.name)
        }
    }
}