package java_11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class Crawler_V3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        var executorService = Executors.newSingleThreadExecutor();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.prudentialplc.com"))
                .GET()
                .build();

        Path path = Path.of("D:\\java\\crawler.text");

        CompletableFuture<Void> start = new CompletableFuture<>();
        var future
                = start.thenCompose(nil -> httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()));

        future.thenAcceptAsync(
                response -> {
                    var body = response.body();
                    System.out.println("Body Len " + body.length() + "[ " + Thread.currentThread().getName() +" ]" );
                }, executorService).thenRun(() -> System.out.println("Done"));
                //.join();

        start.complete(null);
        Thread.sleep(500);
        executorService.shutdown();
    }
}
