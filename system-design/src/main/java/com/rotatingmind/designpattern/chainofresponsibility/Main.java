package com.rotatingmind.designpattern.chainofresponsibility;

import com.rotatingmind.designpattern.chainofresponsibility.data.Request;
import com.rotatingmind.designpattern.chainofresponsibility.handler.RequestHandlerFactory;

public class Main {
    public static void main(String[] args) {
        RequestHandlerFactory.getHandler("playVideo").handle(
                new Request("abc", "def", "ghi")
        );
    }


}
