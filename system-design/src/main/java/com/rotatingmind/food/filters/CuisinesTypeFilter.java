package com.rotatingmind.food.filters;


import com.rotatingmind.food.data.CuisineType;
import com.rotatingmind.food.data.FoodItem;
import com.rotatingmind.food.data.Restaurant;

import java.util.List;

public class CuisinesTypeFilter implements FoodItemFilter, RestaurantFilter{

    private final List<CuisineType> cuisineTypes;

    public CuisinesTypeFilter(List<CuisineType> cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return cuisineTypes.contains(foodItem.getCuisineType());
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        List<CuisineType> cuisines = restaurant.getCuisineTypes();
        for (CuisineType cuisineType : cuisineTypes) {
            if (cuisines.contains(cuisineType))
                return true;
        }
        return false;
    }
}
