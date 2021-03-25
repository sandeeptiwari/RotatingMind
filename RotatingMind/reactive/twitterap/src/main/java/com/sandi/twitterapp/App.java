package com.sandi.twitterapp;


import io.reactivex.Observable;

import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Observable<String> tweets = Observable.just("learning RxJava", "Writing blog about RxJava", "RxJava rocks!!");
       // tweets.subscribe(System.out::println);

        Observable<Integer> obs1 = naturalNumber(10);
        obs1.subscribe(System.out::println);
    }

    public static Observable<Integer> naturalNumber(int n){

        return Observable.create(subscribe -> {
            IntStream.rangeClosed(1, n)
                     .forEach(number -> subscribe.onNext(number));
            subscribe.onComplete();
        });
    }
}
