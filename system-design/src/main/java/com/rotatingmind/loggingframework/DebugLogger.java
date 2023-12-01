package com.rotatingmind.loggingframework;

public class DebugLogger implements Logger {

    private final Logger nextLogLevel;
    private final Publisher publisher;

    public DebugLogger(Logger nextLogLevel, Publisher publisher) {
        this.nextLogLevel = nextLogLevel;
        this.publisher = publisher;
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if (logLevel.getLevel() == LogLevel.DEBUG.getLevel()) {
            publisher.notify(LogLevel.DEBUG + message);
        }
        nextLogLevel.log(logLevel, message);
    }
}
