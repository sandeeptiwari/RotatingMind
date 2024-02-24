package com.rotatingmind.food.perm;


import com.rotatingmind.food.data.Order;
import com.rotatingmind.food.data.OrderStatus;
import com.rotatingmind.food.data.User;

public class UpdateOrderPermission implements Permission{

    private final User user;
    private final Order order;
    private final OrderStatus orderStatus;

    public UpdateOrderPermission(User user, Order order, OrderStatus orderStatus) {
        this.user = user;
        this.order = order;
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean isPermitted() {
        return false;
    }
}
