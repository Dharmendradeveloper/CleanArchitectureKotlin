package com.dharmendra.androidallinone.data.repository

import com.dharmendra.androidallinone.data.model.MealsDTO
import com.dharmendra.androidallinone.data.remote.MealSearchAPI
import com.dharmendra.androidallinone.domain.repository.MealDetailsRepository


class MealDetailsRepositoryImpl(private val mealSearchAPI: MealSearchAPI) : MealDetailsRepository {

    override suspend fun getMealDetails(id: String): MealsDTO {
        return mealSearchAPI.getMealDetails(id)
    }
}