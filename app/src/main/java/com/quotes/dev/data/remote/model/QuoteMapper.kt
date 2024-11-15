package com.quotes.dev.data.remote.model

import com.quotes.dev.domain.model.QuoteData

fun QuoteDto.toDomain(): QuoteData.Quote {
    return QuoteData.Quote(
        quote = this.quote ?: "",
        author = this.author ?: "",
        category = this.category ?: ""
    )
}