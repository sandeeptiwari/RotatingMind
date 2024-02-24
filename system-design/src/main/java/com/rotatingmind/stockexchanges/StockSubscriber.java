package com.rotatingmind.stockexchanges;

public interface StockSubscriber {
    void updateStock(StockName stockName, StockValue stockValue);
}
