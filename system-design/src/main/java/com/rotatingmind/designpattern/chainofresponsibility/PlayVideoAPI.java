package com.rotatingmind.designpattern.chainofresponsibility;

import com.rotatingmind.designpattern.chainofresponsibility.data.Request;
import com.rotatingmind.designpattern.chainofresponsibility.data.Response;
import com.rotatingmind.designpattern.chainofresponsibility.handler.RequestHandler;

import java.util.List;

public class PlayVideoAPI {

    private final List<RequestHandler> handlers;

    public PlayVideoAPI(List<RequestHandler> handlers) {
        this.handlers = handlers;
    }

    public Response playVideo(Request request) {
        handle(request);

        return null;
    }

    private void handle(Request request) {
        handlers.forEach(handler -> handler.handle(request));
    }
}
