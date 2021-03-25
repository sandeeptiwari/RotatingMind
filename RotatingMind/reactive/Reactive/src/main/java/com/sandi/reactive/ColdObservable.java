package com.sandi.reactive;

import io.reactivex.Observable;

public class ColdObservable {

    public static void main(String...args){

        Observable<String> source =
                Observable.just("Alpha","Beta","Gamma","Delta","Epsilon");
        source.subscribe(System.out::println);

        source.subscribe(System.out::println);
    }
}
