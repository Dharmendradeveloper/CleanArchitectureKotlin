package com.dharmendra.androidallinone.data.model

import com.dharmendra.androidallinone.domain.model.Meal

/**
 * you can write your extension function separately
 */

fun MealDTO.toDo(): Meal {
    return Meal(id = idMeal,
    name = strMeal?:"",
    image = strMealThumb?:"")
}