package com.rotatingmind.designpattern.chainofresponsibility.handler;

import com.rotatingmind.designpattern.chainofresponsibility.data.Request;

public interface RequestHandler {

    void handle(Request request);
}
