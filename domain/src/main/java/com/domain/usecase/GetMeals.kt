package com.domain.usecase

import com.domain.repo.MealsRepo

class GetMeals(private val mealsRepo: MealsRepo) {
   suspend operator fun invoke() =mealsRepo.getMealsFromRemote()
}