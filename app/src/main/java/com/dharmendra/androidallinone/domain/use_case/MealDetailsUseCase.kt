package com.dharmendra.androidallinone.domain.use_case


import android.util.Log
import com.dharmendra.androidallinone.common.Resource
import com.dharmendra.androidallinone.data.model.MealsDTO
import com.dharmendra.androidallinone.data.model.toDomainMealDetails
import com.dharmendra.androidallinone.domain.model.MealDetails
import com.dharmendra.androidallinone.domain.repository.MealDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MealDetailsUseCase @Inject constructor(private val repository: MealDetailsRepository) {

    operator fun invoke(id: String): Flow<Resource<List<MealDetails>>> = flow {
        try {
            emit(Resource.Loading())
            val data: MealsDTO = repository.getMealDetails(id)
            val domainData =
                if (!data.meals.isNullOrEmpty()) data.meals.map { it -> it.toDomainMealDetails() } else emptyList()
            emit(Resource.Success(data = domainData))
        } catch (e: HttpException) {
            Log.d("Details", "invoke: http ${e.localizedMessage}")
            emit(Resource.Error(message = e.localizedMessage ?: "An Unknown error occurred"))
        } catch (e: IOException) {
            Log.d("Details", "invoke: IOException ${e.localizedMessage}")
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        } catch (e: Exception) {

        }
    }
}