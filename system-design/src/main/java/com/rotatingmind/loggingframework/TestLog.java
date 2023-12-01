package com.rotatingmind.loggingframework;

import java.io.IOException;

public class TestLog {

    public static void main(String[] args) throws IOException {
        Logger logger = LoggerFactory.getLogger();
        logger.log(LogLevel.DEBUG, "It's debug log");
        logger.log(LogLevel.ERROR, "It's Error log");
    }
}
