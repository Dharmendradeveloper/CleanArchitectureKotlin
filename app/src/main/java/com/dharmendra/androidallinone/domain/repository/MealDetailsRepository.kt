package com.dharmendra.androidallinone.domain.repository

import com.dharmendra.androidallinone.data.model.MealsDTO

interface MealDetailsRepository {

    suspend fun getMealDetails(id:String): MealsDTO

}