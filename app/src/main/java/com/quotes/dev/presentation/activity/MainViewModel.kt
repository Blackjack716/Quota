package com.quotes.dev.presentation.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quotes.dev.domain.features.GetRandomQuoteUseCase
import com.quotes.dev.domain.model.Category
import com.quotes.dev.domain.model.CategoryList
import com.quotes.dev.domain.model.QuoteData
import com.quotes.dev.presentation.ui.UserAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
) : ViewModel()  {

    private val _quote = MutableStateFlow<QuoteData>(QuoteData.Error)
    val quote = _quote.asStateFlow()

    private val _currentCategory = MutableStateFlow(CategoryList().first())

    fun onAction(event: UserAction) {
        when (event) {
            is UserAction.OnButtonClicked -> {
                viewModelScope.launch {
                    getRandomQuote(_currentCategory.value)
                }
            }
            is UserAction.OnCategoryClicked -> {
                _currentCategory.value = event.category
            }
        }
    }

    private fun getRandomQuote(category: Category) {
        viewModelScope.launch {
            _quote.emit(getRandomQuoteUseCase.execute(category))
            println("dupa vm ${_quote.value}" )
        }
    }
}