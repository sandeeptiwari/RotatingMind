package com.sandi.reactive;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class TestConnectableObservable {

    public static void main(String... args) {
        //rangeTest();
        //testTwoInterval();
        //testIntervalWithConnectable();
        // deferTest();
        //maybeTets();
        testCompletable();
    }


    public void TestConnectable() {
        ConnectableObservable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                        .publish();

        //Set up observer 1
        source.subscribe(s -> System.out.println("Observer 1: " + s));
        //Set up observer 2
        source.map(String::length)
                .subscribe(i -> System.out.println("Observer 2: " + i));

        source.connect();
    }

    public static void rangeTest() {
        Observable.range(1, 10).subscribe(System.out::println);
    }

    public static void testTwoInterval() {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);

        //observer - 1
        seconds.subscribe(System.out::println);
        sleep(5000);

        //observer - 2
        seconds.subscribe(System.out::println);

        sleep(5000);
    }

    public static void testIntervalWithConnectable() {
        ConnectableObservable<Long> secodsConn = Observable.interval(1, TimeUnit.SECONDS).publish();

        //observer - 1
        secodsConn.subscribe(System.out::println);
        secodsConn.connect();

        sleep(5000);

        secodsConn.subscribe(System.out::println);

        sleep(5000);
    }

    private static int start = 1;
    private static int count = 5;

    public static void deferTest() {
        //Observable<Integer> source = Observable.range(start,count);
        Observable<Integer> source = Observable.defer(() -> Observable.range(start, count));
        source.subscribe(i -> System.out.println("Observer 1: " + i));
        //modify count
        count = 10;
        source.subscribe(i -> System.out.println("Observer 2: " + i));
    }

    public static void maybeTets() {
        //has emission
        Maybe<Integer> presenceSource = Maybe.just(50);

        presenceSource.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done!"));

    }

    public static void testCompletable() {
        Completable.fromRunnable(() -> runProcess())
                .subscribe(() -> System.out.println("Done!"));
    }

    public static void runProcess() {
        System.out.println("run process start");
        sleep(5000);
    }

    public static void sleep(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
