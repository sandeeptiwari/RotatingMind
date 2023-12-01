package com.rotatingmind.loggingframework;

import java.io.IOException;

public class LoggerFactory {

    private LoggerFactory() {}

    public static Logger getLogger() throws IOException {
        Publisher debugInfoPub = new LogPublisher();
        Publisher warnAndAbovePub = new LogPublisher();
        debugInfoPub.subscribe(new ConsoleSubscriber());
        warnAndAbovePub.subscribe(new ConsoleSubscriber());
        warnAndAbovePub.subscribe(new FileSubscriber("log.txt"));
        return new DebugLogger(
                new InfoLogger(
                        new WarnLogger(
                                new ErrorLogger(
                                        new IdleLogger(),
                                        warnAndAbovePub),
                                warnAndAbovePub
                        ),
                        debugInfoPub
                   ),
                debugInfoPub);
    }
}
