package com.rotatingmind.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentlyOccurElement {

    public long getMostFrequentElement(int[] arr) {

        Map<Integer, Long> byOccurrence = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return byOccurrence.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().intValue() - o1.getValue().intValue())
                .findFirst().get().getKey().intValue();
    }

    public Integer getMostFrequent(int arr[]) {
        Integer maxCount = -1, maxItem = null;
        Map<Integer, Integer> frequencyByEle = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!frequencyByEle.containsKey(arr[i])) {
                frequencyByEle.put(arr[i], 1);
            } else {
                int count = frequencyByEle.get(arr[i]) + 1;
                frequencyByEle.put(arr[i], count);
            }

            if (frequencyByEle.get(arr[i]) > maxCount) {
                maxCount = frequencyByEle.get(arr[i]);
                maxItem = arr[i];
            }
        }
        return maxItem;
    }
}
