package java_11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Crwaler_V2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        var executorService = Executors.newSingleThreadExecutor();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.prudentialplc.com"))
                .GET()
                .build();

        Path path = Path.of("D:\\java\\crawler.text");

        var future = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        future.thenAcceptAsync(
                response -> {
                    var body = response.body();
                    System.out.println("Body Len " + body.length() + "[ " + Thread.currentThread().getName() +" ]" );
                }, executorService).thenRun(() -> System.out.println("Done"))
                .join();
    }
}
