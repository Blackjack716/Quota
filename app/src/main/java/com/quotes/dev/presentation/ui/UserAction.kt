package com.quotes.dev.presentation.ui

import com.quotes.dev.domain.model.Category

sealed class UserAction {
    data class OnCategoryClicked(val category: Category): UserAction()
    data object OnButtonClicked: UserAction()
}