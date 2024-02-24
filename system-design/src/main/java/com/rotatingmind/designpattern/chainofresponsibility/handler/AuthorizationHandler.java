package com.rotatingmind.designpattern.chainofresponsibility.handler;

import com.rotatingmind.designpattern.chainofresponsibility.data.Request;
import com.rotatingmind.designpattern.chainofresponsibility.managers.UserManager;

public class AuthorizationHandler implements RequestHandler {

    private final RequestHandler nextHandler;

    private final UserManager userManager;

    public AuthorizationHandler(RequestHandler nextHandler, UserManager userManager) {
        this.nextHandler = nextHandler;
        this.userManager = userManager;
    }

    @Override
    public void handle(Request request) {
        if (!this.userManager.isSubscribed(request.getToken())) {
            throw new RuntimeException("Authorization failed");
        }
        System.out.println("Authorisation passed");
        this.nextHandler.handle(request);
    }
}
