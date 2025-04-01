package com.rotatingmind.rate_limiter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Implementation of RateLimiter using the Sliding Window algorithm
 */
public class SlidingWindowRateLimiter implements RateLimiter {
    private final int maxRequests;
    private final long windowSizeMillis;
    private final AtomicInteger currentRequests;
    private final AtomicLong windowStartTime;

    /**
     * Creates a new SlidingWindowRateLimiter
     * @param maxRequests maximum number of requests allowed in the window
     * @param windowSizeMillis size of the sliding window in milliseconds
     */
    public SlidingWindowRateLimiter(int maxRequests, long windowSizeMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowSizeMillis;
        this.currentRequests = new AtomicInteger(0);
        this.windowStartTime = new AtomicLong(System.currentTimeMillis());
    }

    @Override
    public boolean tryAcquire() {
        return tryAcquire(1);
    }

    @Override
    public boolean tryAcquire(int permits) {
        if (permits <= 0) {
            return true;
        }

        slideWindow();
        int currentCount = currentRequests.get();

        if (currentCount + permits <= maxRequests) {
            return currentRequests.compareAndSet(currentCount, currentCount + permits);
        }

        return false;
    }

    private void slideWindow() {
        long now = System.currentTimeMillis();
        long windowStart = windowStartTime.get();

        if (now - windowStart >= windowSizeMillis) {
            if (windowStartTime.compareAndSet(windowStart, now)) {
                currentRequests.set(0);
            }
        }
    }
}