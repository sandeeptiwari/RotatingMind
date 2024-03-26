package com.rotatingmind.food.searchers;


import com.rotatingmind.food.data.DataAccessResult;
import com.rotatingmind.food.data.DataAccessor;
import com.rotatingmind.food.data.FoodItem;
import com.rotatingmind.food.filters.FoodItemFilter;

import java.util.ArrayList;
import java.util.List;

public class FoodItemSearcher {

    public List<FoodItem> search(String foodItemName, List<FoodItemFilter> filters) {
        if (foodItemName ==  null || foodItemName.length() == 0 || filters == null)
            throw new IllegalArgumentException("Missing params");
        DataAccessResult dataAccessResult = DataAccessor.getFoodItemsWithName(foodItemName);
        // TODO : Implement DataAccessObjectConverter
        List<FoodItem> foodItems = DataAccessObjectConverter.convertToFoodItems(dataAccessResult);
        for (FoodItemFilter filter : filters) {
            List<FoodItem> filteredFoodItems = new ArrayList<>();
            for (FoodItem foodItem : foodItems) {
                if (filter.filter(foodItem))
                    filteredFoodItems.add(foodItem);
            }
            foodItems = filteredFoodItems;
        }
        return foodItems;
    }

    public FoodItem searchById(int id) {
        return null;
    }

}
