package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KthMinMaxInArray {


    public static void main(String[] args) {
        int arr1[] = {7, 10, 4, 3, 20, 15};
        int arr[] = {7, 10, 4, 3, 20, 15};
        KthMinMaxInArray obj = new KthMinMaxInArray();
        KthMinMax minMax = obj.findMinMax(arr, 4);
        System.out.println(minMax.getMin() + " Max " + minMax.getMax());
    }

    //Input: arr[] = {7, 10, 4, 3, 20, 15}
    public KthMinMax findMinMax(int inputs[], int k) {
        List<KthMinMax> objs = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            int kMin = Integer.MAX_VALUE;
            int kMax = Integer.MIN_VALUE;

            KthMinMax obj = new KthMinMax(min, kMax);
            objs.add(obj);

            for (int index = 0; index < inputs.length; index++) {
                max = inputs[index];
                kMin = inputs[index];

                if (!isMinExist(objs, max) && min > max) {
                    min = max;
                }

                if (!isMaxExist(objs, kMin) && kMax < kMin) {
                    kMax = kMin;
                }

            }

            objs.get(i).setMin(min);
            objs.get(i).setMax(kMax);
        }

        return objs.get(objs.size() - 1);
    }

    private boolean isMinExist(List<KthMinMax> objs, int max) {
        return objs.stream().anyMatch(minMax -> minMax.getMin() == max);
    }

    private boolean isMaxExist(List<KthMinMax> objs, int min) {
        return objs.stream().anyMatch(minMax -> minMax.getMax() == min);
    }

}

class KthMinMax {
    private int min;
    private int max;

    public KthMinMax(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KthMinMax)) return false;
        KthMinMax kthMinMax = (KthMinMax) o;
        return min == kthMinMax.min &&
                max == kthMinMax.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }
}
