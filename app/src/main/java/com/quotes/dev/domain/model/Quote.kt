package com.quotes.dev.domain.model

sealed class QuoteData {
    data class Quote(
        val quote: String,
        val author: String,
        val category: String
    ): QuoteData()
    data object Error: QuoteData()
}