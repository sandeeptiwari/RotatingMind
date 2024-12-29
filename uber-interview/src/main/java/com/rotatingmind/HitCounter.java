package com.rotatingmind;

import java.util.HashMap;
import java.util.Map;


//https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/362-design-hit-counter.html


/**
 *Problem:
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 *
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to
 * the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
 *
 * It is possible that several hits arrive roughly at the same time.
 *
 * Example:
 *
 * HitCounter counter = new HitCounter();
 * // hit at timestamp 1.
 * counter.hit(1);
 * // hit at timestamp 2.
 * counter.hit(2);
 * // hit at timestamp 3.
 * counter.hit(3);
 * // get hits at timestamp 4, should return 3.
 * counter.getHits(4);
 * // hit at timestamp 300.
 * counter.hit(300);
 * // get hits at timestamp 300, should return 4.
 * counter.getHits(300);
 * // get hits at timestamp 301, should return 3.
 * counter.getHits(301);
 */
public class HitCounter {
    // Use a map to store the count of hits for each timestamp

    private final Map<Integer, Integer> hitCounts;

    /** Constructor to initialize the HitCounter object. */
    public HitCounter() {
        this.hitCounts = new HashMap<>();
    }

    /**
     * Record a hit at the given timestamp.
     *
     * @param timestamp - The current timestamp in seconds granularity.
     */
    public void hit(int timestamp) {
        int time = (timestamp > 300) ? timestamp % 300 : timestamp;
        // Increment the hit count for the given timestamp, if it exists; otherwise, set it to 1
        hitCounts.put(timestamp, hitCounts.getOrDefault(timestamp, 0) + 1);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp in seconds granularity.
     * @return the total number of hits in the last 5 minutes.
     */

    public int getHitCount(int timestamp) {
        int time = (timestamp > 300) ? timestamp % 300 : timestamp; // Variable to accumulate the number of hits

        // Iterate through all entries in the map
        // 300 seconds equals 5 minutes
        return hitCounts.entrySet().stream()
                .filter(hit -> (timestamp - hit.getKey()) >= 0 && (timestamp - hit.getKey()) <  300)
                .peek(ele -> {
                    System.out.println("passed " + ele.getKey());
                })
                .map(Map.Entry::getValue)

                .reduce(0, Integer::sum);
    }

    /**
     * HitCounter hitCounter = new HitCounter();
     * hitCounter.hit(timestamp);
     * int numberOfHits = hitCounter.getHits(timestamp);
     *
     * Input
     * ["HitCounter", "hit", "hit", "hit", "getHits", "hit", "getHits", "getHits"]
     * [[], [1], [2], [3], [4], [300], [300], [301]]
     * Output
     * [null, null, null, null, 3, null, 4, 3]
     *
     * Explanation
     * HitCounter hitCounter = new HitCounter();
     * hitCounter.hit(1);       // hit at timestamp 1.
     * hitCounter.hit(2);       // hit at timestamp 2.
     * hitCounter.hit(3);       // hit at timestamp 3.
     * hitCounter.getHits(4);   // get hits at timestamp 4, return 3.
     * hitCounter.hit(300);     // hit at timestamp 300.
     * hitCounter.getHits(300); // get hits at timestamp 300, return 4.
     * hitCounter.getHits(301); // get hits at timestamp 301, return 3.
     *
     */
    public static void main(String[] args) {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        hitCounter.hit(300);


       /* int numberOfHits = hitCounter.getHitCount(4);
        System.out.println("get hits at timestamp 4, " + numberOfHits);

        int numberOfHits1 = hitCounter.getHitCount(300);
        System.out.println("get hits at timestamp 300, " + numberOfHits1);*/

       int numberOfHits2 = hitCounter.getHitCount(301);
        System.out.println("get hits at timestamp 301, " + numberOfHits2);
    }

}
