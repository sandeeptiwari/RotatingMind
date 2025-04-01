package com.rotatingmind.rate_limiter;

public class RateLimiterTest {

    public static void main(String[] args) throws InterruptedException {
        // Test Token Bucket Rate Limiter
        System.out.println("Testing Token Bucket Rate Limiter:");
        RateLimiter tokenBucket = new TokenBucketRateLimiter(5, 2, 1000); // 5 tokens, 2 tokens per second
        testRateLimiter(tokenBucket);

        // Test Sliding Window Rate Limiter
        System.out.println("\nTesting Sliding Window Rate Limiter:");
        RateLimiter slidingWindow = new SlidingWindowRateLimiter(5, 1000); // 5 requests per second
        testRateLimiter(slidingWindow);
    }

    private static void testRateLimiter(RateLimiter limiter) throws InterruptedException {
        // Try to acquire permits rapidly
        for (int i = 0; i < 10; i++) {
            boolean acquired = limiter.tryAcquire();
            System.out.println("Attempt " + (i + 1) + ": " + (acquired ? "Permit acquired" : "Permit denied"));
            Thread.sleep(200); // Wait 200ms between attempts
        }
    }
}
