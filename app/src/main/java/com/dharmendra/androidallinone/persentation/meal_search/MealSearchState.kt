package com.dharmendra.androidallinone.persentation.meal_search

import com.dharmendra.androidallinone.domain.model.Meal


data class MealSearchState(
    val isLoading: Boolean = false,
    val data: List<Meal>? = null,
    val error: String = ""
)