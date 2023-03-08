package com.mealz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel:MealsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView=findViewById(R.id.category_rv)
viewModel.getMeals()
        val mealsAdapter=MealsAdapter()
        lifecycleScope.launch {
            viewModel.categories.collect{
             mealsAdapter.submitList(it?.categories)
                recyclerView.adapter=mealsAdapter

            }
        }

    }
}