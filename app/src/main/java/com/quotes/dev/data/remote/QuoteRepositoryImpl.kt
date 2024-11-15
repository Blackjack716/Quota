package com.quotes.dev.data.remote

import com.haroldadmin.cnradapter.NetworkResponse
import com.quotes.dev.data.remote.model.toDomain
import com.quotes.dev.domain.model.QuoteData
import com.quotes.dev.domain.repository.QuoteRepository
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val quoteApi: QuoteApi
) : QuoteRepository {

    override suspend fun getRandomQuote(): QuoteData {
        return when (val quote = quoteApi.getRandomQuote()) {
            is NetworkResponse.Success -> {
                quote.body.first().toDomain()
            }

            else -> {
                QuoteData.Error
            }
        }
    }

    override suspend fun getRandomQuoteByCategory(category: String): QuoteData {
        return when (val quote = quoteApi.getRandomQuoteByCategory(category = category)) {
            is NetworkResponse.Success -> {
                quote.body.first().toDomain()
            }

            else -> {
                QuoteData.Error
            }
        }
    }
}