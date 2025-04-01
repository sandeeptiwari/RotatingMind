package com.rotatingmind.rate_limiter;

/**
 * Interface defining the core functionality of a Rate Limiter
 */
public interface RateLimiter {
    /**
     * Attempts to acquire a permit to proceed with an operation
     * @return true if permit was acquired, false otherwise
     */
    boolean tryAcquire();

    /**
     * Attempts to acquire multiple permits to proceed with an operation
     * @param permits number of permits to acquire
     * @return true if all permits were acquired, false otherwise
     */
    boolean tryAcquire(int permits);
}