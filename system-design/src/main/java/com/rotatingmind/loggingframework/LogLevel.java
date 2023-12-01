package com.rotatingmind.loggingframework;

public enum LogLevel {
    DEBUG(0),
    INFO(1),
    ERROR(2),
    WARN(3),
    FATAL(4);

    private final int level;

    LogLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
