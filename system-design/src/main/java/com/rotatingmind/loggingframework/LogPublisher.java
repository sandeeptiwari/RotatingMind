package com.rotatingmind.loggingframework;

import java.util.ArrayList;
import java.util.List;

public class LogPublisher implements Publisher {

    private final List<Subscriber> subscriberList;

    public LogPublisher() {
        this.subscriberList = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        this.subscriberList.add(subscriber);
    }

    @Override
    public void unSubscribe(Subscriber subscriber) {
        this.subscriberList.remove(subscriber);

    }

    @Override
    public void notify(String message) {
        this.subscriberList
                .forEach( subscriber -> {
                    subscriber.update(message);
                });
    }
}
