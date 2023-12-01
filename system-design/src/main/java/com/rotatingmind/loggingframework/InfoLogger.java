package com.rotatingmind.loggingframework;

public class InfoLogger implements Logger {

    private final Logger nextLogLevel;
    private final Publisher logPublisher;

    public InfoLogger(Logger nextLogLevel, Publisher logPublisher) {
        this.nextLogLevel = nextLogLevel;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if (logLevel.getLevel() == LogLevel.INFO.getLevel()) {
            this.logPublisher.notify(LogLevel.INFO + message);
        }
        nextLogLevel.log(logLevel, message);
    }
}
