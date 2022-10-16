package com.dharmendra.androidallinone.persentation.meal_details

import com.dharmendra.androidallinone.domain.model.MealDetails

data class MealDetailsState(
    val isLoading: Boolean = false,
    val data: MealDetails? = null,
    val error: String = ""
) {
}