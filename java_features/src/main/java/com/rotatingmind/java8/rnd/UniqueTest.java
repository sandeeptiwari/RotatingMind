package com.rotatingmind.java8.rnd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueTest {

    public static void testUniqueLogs() {
        // Create a list of Log objects with duplicates, including truncated host names
        List<Log> logs = new ArrayList<>();
        logs.add(new Log("host1.example.com", 80));
        logs.add(new Log("host1.exam", 80)); // truncated host name
        logs.add(new Log("host2.example.com", 80));
        logs.add(new Log("host2.example.com", 443));
        logs.add(new Log("host2.example.com", 443));
        logs.add(new Log("host3.example.com", 80));
        logs.add(new Log("host3.example.com", 443));
        logs.add(new Log("host4.example.com", 80));
        logs.add(new Log("host4.example.com", 80));

        // Filter the list to get unique Log objects
        List<Log> uniqueLogs = logs.stream().filter((log1) -> {
            String sourceHost = log1.getHost().substring(0, Math.min(log1.getHost().length(), 10));
            int port = log1.getPort();
            return logs.stream().noneMatch((log2) -> {
                if (log2 == log1) {
                    return false;
                }
                String otherSourceHost = log2.getHost().substring(0, Math.min(log2.getHost().length(), 10));
                return sourceHost.equals(otherSourceHost) && log2.getPort() == port;
            });
        }).collect(Collectors.toList());

        // Verify the results
        System.out.println(uniqueLogs.size());
        System.out.println(uniqueLogs);
    }


    public static void main(String[] args) {
        testUniqueLogs();
    }
}

class Log {
    private String host;
    private int port;

    public Log(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Log{" +
                "host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
