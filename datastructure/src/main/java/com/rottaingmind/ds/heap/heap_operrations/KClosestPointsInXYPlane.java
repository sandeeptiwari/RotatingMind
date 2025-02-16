package com.rottaingmind.ds.heap.heap_operrations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

record Point(int x, int y) {

};

public class KClosestPointsInXYPlane {

    /**
     * orrecting the Comparator
     * To correctly compare two Point objects, let's assume we are sorting them based on their Euclidean distance from the origin (0,0).
     *
     * The Euclidean distance of a point (x, y) from the origin is:
     *
     * distance = sqrt(𝑥^2 + 𝑦^2)
     *
     * @param points
     * @param k
     * @return
     */
    public static int[][] kClosest(int[][] points, int k) {

        int[][] closestPoints = new int[k][2];

        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, (p1, p2) -> {
            double dist1 = Math.sqrt(p1.x() * p1.x() + p1.y() * p1.y());
            double dist2 = Math.sqrt(p2.x() * p2.x() + p2.y() * p2.y());
            int dist = -Double.compare(dist1, dist2); // Compare squared distances
            System.out.println("==== Dist " + dist + " ====");
            return dist;
        });

        // Add all points to the priority queue
        for (int[] point : points) {
            pq.add(new Point(point[0], point[1]));
        }
        System.out.println("======Q " + pq);


        int i = 0;
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            closestPoints[i][0] = p.x(); // Points will be sorted by distance from (0,0)
            closestPoints[i][1] = p.y();
        }

        return closestPoints;
    }

    public static void main(String[] args) {
        int[][] points = {{3, 4}, {1, 2}, {5, 12}, {0, 1}};
        int k = 2;

        int[][] result = kClosest(points, k);

        System.out.println("The " + k + " closest points to origin are:");
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
}
