package com.dharmendra.androidallinone.domain.repository

import com.dharmendra.androidallinone.data.model.MealsDTO


interface MealSearchRepository {

    suspend fun getMealSearch(s:String): MealsDTO



}