package com.dharmendra.androidallinone.data.repository

import com.dharmendra.androidallinone.data.model.MealsDTO
import com.dharmendra.androidallinone.data.remote.MealSearchAPI
import com.dharmendra.androidallinone.domain.repository.MealSearchRepository


class MealSearchRepositoryImpl(private val mealSearchAPI: MealSearchAPI) : MealSearchRepository {

    override suspend fun getMealSearch(s: String): MealsDTO {
        return mealSearchAPI.getSearchMealList(s)
    }
}