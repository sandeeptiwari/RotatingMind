package com.rotatingmind.food.filters;


import com.rotatingmind.food.data.FoodItem;
import com.rotatingmind.food.data.MealType;
import com.rotatingmind.food.data.Restaurant;

public class MealTypeFilter implements FoodItemFilter, RestaurantFilter{

    private final MealType mealType;

    public MealTypeFilter(MealType mealType) {
        this.mealType = mealType;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getMealType().equals(mealType);
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        return restaurant.getMealType().equals(mealType);
    }
}
