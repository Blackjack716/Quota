package com.quotes.dev.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class QuoteDto {
    @SerializedName("quote")
    @Expose
    val quote: String? = null

    @SerializedName("author")
    @Expose
    val author: String? = null

    @SerializedName("category")
    @Expose
    val category: String? = null
}