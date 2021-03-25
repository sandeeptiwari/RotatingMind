package java_11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Http2Client {

    public static void main(String[] args) {
        HttpClient httpClient =
                HttpClient.newBuilder()
                        .version(HttpClient.Version.HTTP_2)
                        .build();
        HttpRequest req = HttpRequest.newBuilder(URI.create("https://google.com"))
                .GET()
                .build();
        CompletableFuture<HttpResponse<String>> resFuture
                = httpClient.sendAsync(req, HttpResponse.BodyHandlers.ofString());
        resFuture.thenAccept(res -> System.out.println(res.version()));
        resFuture.join();
        System.out.println("I am in main thread");
    }
}
