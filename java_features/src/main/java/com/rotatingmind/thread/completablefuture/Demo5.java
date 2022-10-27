package com.rotatingmind.thread.completablefuture;

import com.rotatingmind.thread.completablefuture.service.CreditRatingService;
import com.rotatingmind.thread.completablefuture.service.UserService;
import com.sandi.jvm.methodbinding.User;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Demo5 {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new IllegalStateException(e);
                    }
                    return "Sandeep";
                })
                .thenApply(name -> "Hello " + name)
                .thenApply(greeting -> greeting + "Welcome to the CompletableFuture World")
                .thenAccept(product -> {
                    System.out.println("Consume the result " + product);
                }).join();
    }

    public CompletableFuture<Double> combine(User user) {
        //If your callback function returns a CompletableFuture, and you want a flattened result from the
        // CompletableFuture chain (which in most cases you would), then use thenCompose().
        //CompletableFuture<CompletableFuture<Double>> future = getUsersDetail(String.valueOf(user.id)).thenApply(this::getCreditRating);
        return getUsersDetail(String.valueOf(user.id)).thenCompose(this::getCreditRating);
    }

    CompletableFuture<User> getUsersDetail(String userId) {
        return CompletableFuture.supplyAsync(() -> UserService.getUserDetails(userId));
    }

    CompletableFuture<Double> getCreditRating(User user) {
        return CompletableFuture.supplyAsync(() -> CreditRatingService.getCreditRating(user));
    }
}
