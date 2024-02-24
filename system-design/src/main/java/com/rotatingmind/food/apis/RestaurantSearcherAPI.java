package com.rotatingmind.food.apis;


import com.rotatingmind.food.data.CuisineType;
import com.rotatingmind.food.data.MealType;
import com.rotatingmind.food.data.Restaurant;
import com.rotatingmind.food.data.StarRating;
import com.rotatingmind.food.filters.CuisinesTypeFilter;
import com.rotatingmind.food.filters.MealTypeFilter;
import com.rotatingmind.food.filters.RestaurantFilter;
import com.rotatingmind.food.filters.StarRatingFilter;
import com.rotatingmind.food.searchers.RestaurantSearcher;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSearcherAPI {

    public List<Restaurant> searchRestaurant(String restaurantName, MealType mealType, List<CuisineType> cuisineTypes, StarRating rating) {
        // validations
        List<RestaurantFilter> filters = new ArrayList<>();
        if (mealType != null)
            filters.add(new MealTypeFilter(mealType));
        if (cuisineTypes != null)
            filters.add(new CuisinesTypeFilter((cuisineTypes)));
        if (rating != null)
            filters.add(new StarRatingFilter(rating));
        return new RestaurantSearcher().search(restaurantName, filters);
    }

}
