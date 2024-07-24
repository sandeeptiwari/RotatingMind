package com.rotatingmind.food.filters;


import com.rotatingmind.food.data.FoodItem;
import com.rotatingmind.food.data.Restaurant;
import com.rotatingmind.food.data.StarRating;

public class StarRatingFilter implements FoodItemFilter, RestaurantFilter {

    private final StarRating rating;

    public StarRatingFilter(StarRating rating) {
        this.rating = rating;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getStarRating().getVal() >= rating.getVal();
    }

    @Override
    public boolean filter(Restaurant restaurant) {
        return restaurant.getRating().getVal() >= rating.getVal();
    }
}
