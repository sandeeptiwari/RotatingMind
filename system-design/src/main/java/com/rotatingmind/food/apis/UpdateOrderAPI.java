package com.rotatingmind.food.apis;


import com.rotatingmind.food.data.Order;
import com.rotatingmind.food.data.OrderStatus;
import com.rotatingmind.food.data.User;
import com.rotatingmind.food.managers.OrderManager;
import com.rotatingmind.food.managers.UserManager;

public class UpdateOrderAPI {

    UserManager userManager = new UserManager();
    OrderManager orderManager = new OrderManager();

    public void updateOrder(int orderId, OrderStatus status, String userToken) {
        //...
        User user = userManager.getUserByToken(userToken);
        //
         Order order = orderManager.getOrder(orderId);
         //
        if (status.equals(OrderStatus.COOKING))
            orderManager.setOrderToCooking(user, order);

    }

}
