package com.sandi.twitterapp;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import twitter4j.Status;

public class TwitAnalyser {



    public static void main(String...args){
        String searchterms[] = {"Narendra Modi"};


        ConnectableObservable<Status> connectableObservable = TweetObservable.tweetObservable(searchterms).publish();

        connectableObservable.connect();

        Observable<String> tweetStream = connectableObservable.map(Status::getText);
        tweetStream.forEach(System.out::println);
    }
}
