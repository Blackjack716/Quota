package com.quotes.dev.data

import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import com.quotes.dev.data.remote.QuoteApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Provides
    @Singleton
    fun provideApi(): QuoteApi {
        return Retrofit.Builder()
            .baseUrl(API_QUOTE)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .build()
            .create(QuoteApi::class.java)
    }

    companion object {
        const val API_QUOTE = "https://api.api-ninjas.com/v1/"
    }

}