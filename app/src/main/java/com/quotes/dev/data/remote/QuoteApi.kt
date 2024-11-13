package com.quotes.dev.data.remote

import com.haroldadmin.cnradapter.NetworkResponse
import com.quotes.dev.data.remote.model.ErrorResponse
import com.quotes.dev.data.remote.model.QuoteDto
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    @GET("quotes")
    suspend fun getRandomQuote(): NetworkResponse<QuoteDto, ErrorResponse>

    @GET("quotes")
    suspend fun getRandomQuoteByCategory(
        @Query("category") category: String
    ): NetworkResponse<QuoteDto, ErrorResponse>
}