package com.rotatingmind.loggingframework;

public class WarnLogger implements Logger {

    private final Logger nextLogLevel;
    private final Publisher publisher;

    public WarnLogger(Logger nextLogLevel, Publisher publisher) {
        this.nextLogLevel = nextLogLevel;
        this.publisher = publisher;
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if (logLevel.getLevel() == LogLevel.WARN.getLevel()) {

        }
        nextLogLevel.log(logLevel, message);
    }
}
