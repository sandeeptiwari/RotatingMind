package com.rotatingmind.food.apis;


import com.rotatingmind.food.data.Order;
import com.rotatingmind.food.data.PaymentResponse;
import com.rotatingmind.food.data.PaymentStatus;
import com.rotatingmind.food.data.User;
import com.rotatingmind.food.factory.PaymentManagerFactory;
import com.rotatingmind.food.managers.OrderManager;
import com.rotatingmind.food.managers.PaymentManager;
import com.rotatingmind.food.managers.UserManager;

import java.util.Map;

public class PlaceOrderAPI {

    private final UserManager userManager = new UserManager();
    private final OrderManager orderManager = new OrderManager();

    public Order placeOrder(String userToken, Map<String, String> paymentInfo, String paymentMode) {
        if (userToken == null || userToken.length() == 0)
            throw new IllegalArgumentException("Params missing");
        User user = userManager.getUserByToken(userToken);
        if (user == null)
            throw new IllegalArgumentException("userToken Invalid");
        PaymentManager paymentManager = PaymentManagerFactory.getPaymentManager(paymentMode, paymentInfo);
        PaymentResponse paymentResponse = paymentManager.executePayment();
        if (paymentResponse == null || paymentResponse.getStatus() == null || paymentResponse.getStatus().equals(PaymentStatus.FAILED))
            throw new RuntimeException("payment failed...");
        return orderManager.placeOrder(user);
    }

}
