package com.rotatingmind.food.filters;


import com.rotatingmind.food.data.FoodItem;

public interface FoodItemFilter {

    boolean filter(FoodItem foodItem);

}
