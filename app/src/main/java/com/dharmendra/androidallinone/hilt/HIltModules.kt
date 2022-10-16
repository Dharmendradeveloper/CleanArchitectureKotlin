package com.dharmendra.androidallinone.hilt


import com.dharmendra.androidallinone.common.Constants
import com.dharmendra.androidallinone.data.remote.MealSearchAPI
import com.dharmendra.androidallinone.data.repository.MealDetailsRepositoryImpl
import com.dharmendra.androidallinone.data.repository.MealSearchRepositoryImpl
import com.dharmendra.androidallinone.domain.repository.MealDetailsRepository
import com.dharmendra.androidallinone.domain.repository.MealSearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HIltModules {

    @Provides
    @Singleton
    fun provideMealSearchAPI(): MealSearchAPI {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(MealSearchAPI::class.java)
    }

    @Provides
    fun provideMealSearchRepository(mealSearchAPI: MealSearchAPI): MealSearchRepository {
        return MealSearchRepositoryImpl(mealSearchAPI)
    }

    @Provides
    fun provideMealDetails(searchMealSearchAPI: MealSearchAPI): MealDetailsRepository {
        return MealDetailsRepositoryImpl(searchMealSearchAPI)
    }
}