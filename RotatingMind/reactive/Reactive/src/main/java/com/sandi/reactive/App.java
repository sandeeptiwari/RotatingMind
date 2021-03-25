package com.sandi.reactive;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*List<String> colors = Arrays.asList("RED", "ORANGE", "GREEN", "BLACK", "BLUE", "VIOLET", "SILVER");
        Observable<Integer> observable = Observable.fromIterable(colors).map(String::length);

        Consumer<Integer> onNext = System.out::println;
        Action onComplete = () -> System.out.println("Done");
        Consumer<Throwable> error = Throwable::printStackTrace;

        observable.subscribe(onNext, error, onComplete);*/

        //testAlpha();

        //testTake();

        //testTakeWhile();

        //testRepeatMethod();

       //testScan();

        //testCount();

        //testReduce1();

        //testReduce2();

        //testAll();

        //testAny();

        //testToList();

        //testToMap();

        testCollect();
    }

    private static void testCollect() {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                  .collect(HashSet::new, HashSet::add)
                  .subscribe(System.out::println);
    }

    private static void testToMap() {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                  .toMap(s -> s.charAt(0), String::length)
                  .subscribe(System.out::println);
    }

    private static void testToList() {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                  .toList()
                  .subscribe(System.out::println);
    }

    private static void testAny() {
        Observable.just("2016-01-01", "2016-05-02", "2016-09-12", "2016-04-03")
                  .map(LocalDate::parse)
                  .any(dt -> dt.getMonthValue() >= 6)
                  .subscribe(System.out::println);
    }

    private static void testAll() {
        Observable.just(5, 3, 7, 11, 2, 14)
                  .all(i -> i < 10)
                  .subscribe(System.out::println);
    }

    private static void testReduce2() {
        Observable.just(5, 3, 7, 10, 2, 14)
                .reduce("", (total, next) -> total + ( total.equals("") ? "" : ", ") + next)
                .subscribe(System.out::println);
    }

    private static void testReduce() {
        Observable.just(5, 3, 7, 10, 2, 14)
                .reduce((total, next) -> total + next)
                .subscribe(s -> System.out.println("Received: " + s));
    }

    private static void testCount() {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .count()
                .subscribe(s -> System.out.println("Received: " + s));
    }

    private static void testRepeatMethod() {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                  .repeat(2)
                  .subscribe(System.out::println);
    }


    public static void testAlpha(){
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                  .filter( e -> e.length() >= 5)
                  .forEach(System.out::println);
    }

    public static void testTake(){
        Consumer<String> onNext = System.out::println;
        Consumer<Throwable> error = Throwable::printStackTrace;
        Action action = () -> System.out.println("completed");

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                   .take(2)
                   .subscribe(onNext, error, action);
    }

    public static void testTakeWhile(){
        Observable.range(1, 100)
                  .takeWhile(e -> e < 5)
                  .subscribe(System.out::println);
    }

    public static void testScan(){
        Observable.just(5, 3, 7, 10, 2, 14)
                .scan((accumulator, next) -> accumulator + next)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
