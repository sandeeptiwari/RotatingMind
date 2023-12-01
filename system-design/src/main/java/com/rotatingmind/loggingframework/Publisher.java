package com.rotatingmind.loggingframework;

public interface Publisher {

    void subscribe(Subscriber subscriber);

    void unSubscribe(Subscriber subscriber);

    void notify(String message);
}
