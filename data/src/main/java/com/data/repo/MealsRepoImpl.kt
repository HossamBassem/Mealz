package com.data.repo

import com.data.remote.ApiService
import com.domain.entity.CategoryResponse
import com.domain.repo.MealsRepo

class MealsRepoImpl(private val apiService: ApiService):MealsRepo {
    override suspend fun getMealsFromRemote(): CategoryResponse =apiService.getMeals()


}