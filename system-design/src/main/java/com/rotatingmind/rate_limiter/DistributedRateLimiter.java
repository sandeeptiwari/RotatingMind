package com.rotatingmind.rate_limiter;

/**
 * Interface for distributed rate limiting scenarios
 * Extends the base RateLimiter interface with distributed capabilities
 */
public interface DistributedRateLimiter extends RateLimiter {
    /**
     * Attempts to acquire permits for a specific key (e.g., user ID, IP address)
     * @param key the identifier for rate limiting
     * @return true if permit was acquired, false otherwise
     */
    boolean tryAcquire(String key);

    /**
     * Attempts to acquire multiple permits for a specific key
     * @param key the identifier for rate limiting
     * @param permits number of permits to acquire
     * @return true if all permits were acquired, false otherwise
     */
    boolean tryAcquire(String key, int permits);

    /**
     * Resets the rate limit for a specific key
     * @param key the identifier for rate limiting
     */
    void reset(String key);
}
