package com.rotatingmind.rate_limiter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Implementation of RateLimiter using the Token Bucket algorithm
 */
public class TokenBucketRateLimiter implements RateLimiter {

    private final long capacity;
    private final long refillRate;
    private final AtomicLong tokens;
    private final long refillPeriodMillis;
    private volatile long lastRefillTime;

    /**
     * Creates a new TokenBucketRateLimiter
     * @param capacity maximum number of tokens the bucket can hold
     * @param refillRate number of tokens to add per refill period
     * @param refillPeriodMillis time period in milliseconds between refills
     */
    public TokenBucketRateLimiter(long capacity, long refillRate, long refillPeriodMillis) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.refillPeriodMillis = refillPeriodMillis;
        this.tokens = new AtomicLong(capacity);
        this.lastRefillTime = System.currentTimeMillis();
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

        refillTokens();
        long currentTokens = tokens.get();

        if (currentTokens >= permits) {
            return tokens.compareAndSet(currentTokens, currentTokens - permits);
        }

        return false;
    }

    private void refillTokens() {
        long now = System.currentTimeMillis();
        long timePassed = now - lastRefillTime;

        if (timePassed >= refillPeriodMillis) {
            long tokensToAdd = (timePassed / refillPeriodMillis) * refillRate;
            if (tokensToAdd > 0) {
                long currentTokens = tokens.get();
                long newTokens = Math.min(capacity, currentTokens + tokensToAdd);
                tokens.compareAndSet(currentTokens, newTokens);
                lastRefillTime = now;
            }
        }
    }
}
