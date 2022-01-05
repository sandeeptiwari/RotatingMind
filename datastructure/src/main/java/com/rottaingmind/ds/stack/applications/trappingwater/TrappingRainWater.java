package com.rottaingmind.ds.stack.applications.trappingwater;

public class TrappingRainWater {

    public int getTrappingWater(int[] towerHieghts) {
        int len = towerHieghts.length;
        int waterUnit = 0;

        if (towerHieghts == null || len <= 2) {
            return 0;
        }
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = towerHieghts[0];
        for (int i = 1; i < len; i++) {
            int current = towerHieghts[i];
            left[i] = Math.max(left[i - 1], current);
        }

        right[len - 1] = towerHieghts[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            int current = towerHieghts[i];
            right[i] = Math.max(right[i + 1], current);
        }

        for (int i = 0; i < len; i++) {
            waterUnit += (Math.min(left[i], right[i]) - towerHieghts[i]);
        }
        return waterUnit;
    }

    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater rainWater = new TrappingRainWater();
        // System.out.print(rainWater.getTrappingWater(height));
    }

}
