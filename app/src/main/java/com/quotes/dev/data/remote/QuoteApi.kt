package com.quotes.dev.data.remote

import com.haroldadmin.cnradapter.NetworkResponse
import com.quotes.dev.BuildConfig
import com.quotes.dev.data.remote.model.ErrorResponse
import com.quotes.dev.data.remote.model.QuoteDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface QuoteApi {

    @GET("quotes")
    suspend fun getRandomQuote(
        @Header("X-Api-Key") header: String = BuildConfig.API_KEY
    ): NetworkResponse<List<QuoteDto>, ErrorResponse>

    @GET("quotes")
    suspend fun getRandomQuoteByCategory(
        @Header("X-Api-Key") header: String = BuildConfig.API_KEY,
        @Query("category") category: String
    ): NetworkResponse<List<QuoteDto>, ErrorResponse>
}