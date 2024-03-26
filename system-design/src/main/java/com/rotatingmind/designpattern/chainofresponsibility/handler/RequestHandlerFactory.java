package com.rotatingmind.designpattern.chainofresponsibility.handler;

import com.rotatingmind.designpattern.chainofresponsibility.managers.TokenManager;
import com.rotatingmind.designpattern.chainofresponsibility.managers.UserManager;

public class RequestHandlerFactory {

    private RequestHandlerFactory() {}

    public static RequestHandler getHandler(String apiName) {
        return new ValidationHandler(new AuthenticationHandler(new AuthorizationHandler(
                new IdleHandler(), new UserManager()),
                new TokenManager()));
    }

}
