package com.rotatingmind.thread.course;

/**
 * Background task, that should not block our application from terminating.
 *
 * Example: File saving thread in a text Editor
 */
public class DaemonThread {

    public static void main(String[] args) {
        // in chapter 03 example eventhough premature long calculation
        // if we set damon thrad true then no need to check isInterupt inside thread and return BuigInteger.Zero
        // check in chapter03
    }
}
