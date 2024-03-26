package com.rotatingmind.stockexchanges;


import java.util.ArrayList;
import java.util.List;

public class StockUpdatesPublisher implements StockPublisher {

    private final String name;
    private List<StockSubscriber> subscribers;

    public StockUpdatesPublisher(String name) {
        this.name = name;
        subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(StockSubscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(StockSubscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscriber(StockName stockName, StockValue stockValue) {
        subscribers.forEach(subscriber -> subscriber.updateStock(stockName, stockValue));
    }
}
