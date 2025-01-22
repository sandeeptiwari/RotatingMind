package com.rottaingmind.ds.heap.heap_operrations.ksmallestsumpairs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

record Pair(int i, int j) {
}

public class KSmallPairSum {

    private static void gtePairSum(int k, PriorityQueue<Pair> pq, Map<Pair, Boolean> pairByIndex, int [] arr1, int [] arr2) {
        pq.add(new Pair(0, 0));
        pairByIndex.put(new Pair(0, 0), true);

        while (k > 0) {
            Pair p = pq.poll();
            System.out.println( arr1[p.i()] + arr2[p.j()] );
            if (!pairByIndex.get(new Pair(p.i(), p.j() + 1)) && p.j() + 1 < arr2.length) {
                pq.offer(new Pair(p.i(), p.j() + 1));
                pairByIndex.put(new Pair(p.i(), p.j() + 1), true);
            }

            if (!pairByIndex.get(new Pair(p.i() + 1, p.j())) && p.i() + 1 < arr1.length) {
                pq.offer(new Pair(p.i() + 1, p.j()));
                pairByIndex.put(new Pair(p.i() + 1, p.j()), true);
            }

            k--;
        }

    }


    // log 1, log 2... log i = k log k
    // o
    public static void main(String[] args) {
        int [] arr1 = {5, 7, 11, 12};
        int [] arr2 = {4, 9, 10};
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> (arr1[p1.i()]  + arr1[p1.j()]) - (arr1[p2.i()]  + arr2[p2.j()]));
        Map<Pair, Boolean> pairByIndex = new HashMap<>();
        int k = 4;
        gtePairSum(k, pq, pairByIndex, arr1, arr2);
    }
}
