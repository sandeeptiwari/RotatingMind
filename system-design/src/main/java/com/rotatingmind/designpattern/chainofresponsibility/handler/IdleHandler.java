package com.rotatingmind.designpattern.chainofresponsibility.handler;

import com.rotatingmind.designpattern.chainofresponsibility.data.Request;

public class IdleHandler implements RequestHandler {

    @Override
    public void handle(Request request) {
        System.out.println("All done");
    }
}
