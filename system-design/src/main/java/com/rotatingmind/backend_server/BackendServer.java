package com.rotatingmind.backend_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class BackendServer {
    private static final int PORT = 9093;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(8);
    private static final List<String> backendServers = Arrays.asList(
            "127.0.0.1:8081",
            "127.0.0.1:8082",
            "127.0.0.1:8083"
    );
    private static final AtomicInteger roundRobinIndex = new AtomicInteger(0);

    public void startServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Backend running on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                executorService.submit(() -> handleClient(clientSocket));
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (InputStream clientIn = clientSocket.getInputStream();
             OutputStream clientOut = clientSocket.getOutputStream()) {

            // Select backend (Round Robin)
            String backendAddress = getNextBackend();
            String[] parts = backendAddress.split(":");
            String backendIp = parts[0];
            int backendPort = Integer.parseInt(parts[1]);

            System.out.println("Forwarding request to " + backendAddress);

            // Open TCP connection to backend

            try (Socket backendSocket = new Socket(backendIp, backendPort);
                 InputStream backendIn = backendSocket.getInputStream();
                 OutputStream backendOut = backendSocket.getOutputStream()) {

                // Forward request to backend
                byte[] buffer = new byte[4096];
                int bytesRead = clientIn.read(buffer);
                if (bytesRead > 0) {
                    backendOut.write(buffer, 0, bytesRead);
                    backendOut.flush();
                }

                // Get response from backend and send to client
                int responseBytes = backendIn.read(buffer);
                if (responseBytes > 0) {
                    clientOut.write(buffer, 0, responseBytes);
                    clientOut.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getNextBackend() {
        int index = roundRobinIndex.getAndIncrement() % backendServers.size();
        return backendServers.get(index);
    }


    public static void main(String[] args) throws IOException {
        BackendServer obj = new BackendServer();
        obj.startServer();
    }
}
