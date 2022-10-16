package com.dharmendra.androidallinone.persentation.meal_details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dharmendra.androidallinone.common.Resource
import com.dharmendra.androidallinone.domain.use_case.MealDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(private val mealDetailsUseCase: MealDetailsUseCase):ViewModel() {

    private var _mealDetails = MutableStateFlow<MealDetailsState>(MealDetailsState())
    val mealDetails:StateFlow<MealDetailsState> = _mealDetails

    fun getMealDetails(id:String){
        println("Details $id")
        mealDetailsUseCase(id).onEach {
            when(it){
                is Resource.Loading ->{
                    Log.d("Details", "getMealDetails: Loading ")
                    _mealDetails.value = MealDetailsState(isLoading = true)
                }
                is Resource.Error ->{
                    Log.d("Details", "getMealDetails: Error ${it.message} ")
                    _mealDetails.value = MealDetailsState(error = it.message?:"")
                }
                is Resource.Success ->{
                    Log.d("Details", "getMealDetails: Success ${it.data} ")
                    _mealDetails.value = MealDetailsState(data = it.data?.get(0))
                }
            }
        }.launchIn(viewModelScope)
    }






}