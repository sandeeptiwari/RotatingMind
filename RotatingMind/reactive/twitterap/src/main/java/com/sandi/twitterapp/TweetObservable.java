package com.sandi.twitterapp;

import io.reactivex.Observable;
import io.reactivex.Observer;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public final class TweetObservable {

    public static Observable<Status> tweetObservable(String...searchKeyword){

        return Observable.create(subscriber -> {

            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true);
            cb.setOAuthConsumerKey(TwitterApp.CONSUMERKEY);
            cb.setOAuthConsumerSecret(TwitterApp.CONSUMERSECRET);
            cb.setOAuthAccessToken(TwitterApp.ACCESSTOKEN);
            cb.setOAuthAccessTokenSecret(TwitterApp.ACCESSTOKENSECRET);

            TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();

            twitterStream.addListener(new StatusAdapter(){

                public void onStatus(Status status) {
                    subscriber.onNext(status);
                }

                public void onException(Exception ex) {
                    subscriber.onError(ex);
                }

            });

            FilterQuery filterQuery = new FilterQuery();
            filterQuery.language(new String[]{"en"});
            filterQuery.track(searchKeyword);
            twitterStream.filter(filterQuery);
        });
    }
}
