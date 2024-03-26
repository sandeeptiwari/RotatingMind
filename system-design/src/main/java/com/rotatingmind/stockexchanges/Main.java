package com.rotatingmind.stockexchanges;

import static com.rotatingmind.stockexchanges.Currency.INR;

public class Main {

    public static void main(String[] args) {
        StockPublisher bsePublisher = new StockUpdatesPublisher("BSE");
        StockPublisher nsePublisher = new StockUpdatesPublisher("NSE");
        StockSubscriber subscriber1 = new StockUpdatesSubscriber("subs1");
        StockSubscriber subscriber2 = new StockUpdatesSubscriber("subs2");
        StockSubscriber subscriber3 = new StockUpdatesSubscriber("subs3");

        bsePublisher.subscribe(subscriber2);
        bsePublisher.subscribe(subscriber3);

        nsePublisher.subscribe(subscriber1);
        nsePublisher.subscribe(subscriber2);


        nsePublisher.notifySubscriber(StockName.AMZN, new StockValue(1, 100, INR));
        nsePublisher.notifySubscriber(StockName.AMZN, new StockValue(2, 200, INR));

        bsePublisher.notifySubscriber(StockName.AMZN, new StockValue(1, 100, INR));
        bsePublisher.notifySubscriber(StockName.NETFLIX, new StockValue(1, 200, INR));
    }
}
