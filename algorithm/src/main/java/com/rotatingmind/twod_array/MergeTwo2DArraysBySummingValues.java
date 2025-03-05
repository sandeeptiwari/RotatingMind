package com.rotatingmind.twod_array;

import java.util.*;

public class MergeTwo2DArraysBySummingValues {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] result = new int[n + m][2];
        Map<Integer, Integer> indexByKey = new HashMap<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            int[] pair1 = nums1[i];
            int[] pair2 = nums2[j];
            if (indexByKey.containsKey(pair1[0]) || indexByKey.containsKey(pair2[0])) {
                result[k][1] = pair1[1] + pair2[1];
                i++;
                j++;
            } else {

                if (pair1[0] < pair2[0]) {
                    result[k] = pair1;
                    indexByKey.put(pair1[0], k++);

                    if (indexByKey.containsKey(pair2[0])) {
                        int idx = indexByKey.get(pair2[0]);
                        result[idx][1] = pair1[1] + pair2[1];
                    } else {
                        result[k] = pair2;
                        indexByKey.put(pair2[0], k++);
                    }
                } else {
                    result[k] = pair2;
                    indexByKey.put(pair2[0], k++);
                    if (indexByKey.containsKey(pair1[0])) {
                        int idx = indexByKey.get(pair1[0]);
                        result[idx][1] = pair1[1] + pair2[1];
                    } else {
                        result[k] = pair1;
                        indexByKey.put(pair1[0], k++);
                    }
                }

                i++;
                j++;
            }
        }


        while (i < n) {
            int[] pair1 = nums1[i];

            if (indexByKey.containsKey(pair1[0])) {
                int idx = indexByKey.get(pair1[0]);
                result[idx][1] += pair1[1];
            } else {
                result[k] = pair1;
                indexByKey.put(pair1[0], k++);
            }
            i++;
        }

        while (j < m) {
            int[] pair2 = nums2[j];

            if (indexByKey.containsKey(pair2[0])) {
                int idx = indexByKey.get(pair2[0]);
                result[idx][1] += pair2[1];
            } else {
                result[k++] = pair2;
                indexByKey.put(pair2[0], k);
            }
            j++;
        }
        return result;
    }

    public int[][] mergeArrays3(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        int n = nums1.length, m = nums2.length;

        while (i < n && j < m) {
            if (nums1[i][0] == nums2[j][0]) {
                // Merge values when keys match
                result.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                result.add(nums1[i]);
                i++;
            } else {
                result.add(nums2[j]);
                j++;
            }
        }

        // Add remaining elements from nums1 (if any)
        while (i < n) {
            result.add(nums1[i++]);
        }

        // Add remaining elements from nums2 (if any)
        while (j < m) {
            result.add(nums2[j++]);
        }

        return result.toArray(new int[result.size()][]);
    }



    public int[][] mergeArrays2(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Merge nums1 into the map
        for (int[] pair : nums1) {
            map.put(pair[0], map.getOrDefault(pair[0], 0) + pair[1]);
        }

        // Merge nums2 into the map
        for (int[] pair : nums2) {
            map.put(pair[0], map.getOrDefault(pair[0], 0) + pair[1]);
        }

        // Convert map entries to result array
        int[][] result = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[index++] = new int[]{entry.getKey(), entry.getValue()};
        }

        return result;
    }

    /**
     * Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
     * Output: [[1,6],[2,3],[3,2],[4,6]]
     * <p>
     * Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
     *
     * @param args
     */
    public static void main(String[] args) {
         int[][] nums1 = {{2,4}, {3,6}, {5,5}};
         int[][] nums2 = {{1, 3}, {4, 3}};

         MergeTwo2DArraysBySummingValues obj = new MergeTwo2DArraysBySummingValues();
         int[][] result = obj.mergeArrays(nums1, nums2); //[[1,3],[2,4],[3,6],[4,3],[5,5]]

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j <result[0].length ; j++) {
                System.out.print(result[i][j] + " ");
                //System.out.println("");
            }
        }
    }
}
