package com.rotatingmind.stockexchanges;

public interface StockPublisher {

    void subscribe(StockSubscriber subscriber);

    void unsubscribe(StockSubscriber subscriber);

    void notifySubscriber(StockName stockName, StockValue stockValue);
}
