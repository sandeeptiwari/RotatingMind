package com.rotatingmind.food.filters;


import com.rotatingmind.food.data.Restaurant;

public interface RestaurantFilter {

    boolean filter(Restaurant restaurant);

}
