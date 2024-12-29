package com.rotatingmind.food.apis;


import com.rotatingmind.food.data.FoodItem;
import com.rotatingmind.food.data.User;
import com.rotatingmind.food.managers.CartManager;
import com.rotatingmind.food.managers.UserManager;
import com.rotatingmind.food.searchers.FoodItemSearcher;

public class AddToCartAPI {

    private final UserManager userManager = new UserManager();
    private final FoodItemSearcher foodItemSearcher = new FoodItemSearcher();
    private final CartManager cartManager = new CartManager();

    public void addToCart(String userToken, int foodItemId) {
        if (userToken == null || userToken.length() == 0 || foodItemId < 0) {
            //
        }
        User user = userManager.getUserByToken(userToken);
        if (user == null) {
            //exception
        }
        FoodItem foodItem = foodItemSearcher.searchById(foodItemId);
        if (foodItem == null) {
            // throw exception no food found
        }
        cartManager.addItemToCart(user, foodItem);
    }

}
