package com.rotatingmind.java11.httclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientAsync {

    public static void main(String[] args) {
        HttpClient httpClient =
                HttpClient.newBuilder()
                        .version(HttpClient.Version.HTTP_2)
                        .build();

        HttpRequest request
                = HttpRequest.newBuilder(URI.create("https://google.com"))
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> resCompletableFuture
                = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        resCompletableFuture.thenAccept(res -> System.out.println(res.version()));

        resCompletableFuture.join();

        System.out.println("Thread " + Thread.currentThread().getName());

    }
}
