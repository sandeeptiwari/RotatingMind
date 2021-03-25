/*Input : arr[] = {2, 3, 5, 6, 8, 10}
        sum = 10
        Output : 5 2 3
        2 8
        10*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSumDemo {

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();

        if(candidates == null || candidates.length == 0)
            return result;

        //sort the array
        Arrays.sort(candidates);

        List<Integer> combination = new ArrayList<>();
        toFindCombinationToTarget(result, combination, candidates, target, 0);

        return result;
    }

    private void toFindCombinationToTarget(List<List<Integer>> result, List<Integer> combination, int[] candidates, int target, int startIndex) {

        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {

            if(candidates[i] > target)
                break;

            combination.add(candidates[i]);
            toFindCombinationToTarget(result, combination, candidates,target - candidates[i], i);

            combination.remove(combination.size() - 1);
        }

    }

    public static void main(String...args){
        PerfectSumDemo perfectSumDemo = new PerfectSumDemo();
        int[]arr = {2, 3, 6, 7};
        perfectSumDemo.combinationSum(arr, 7).stream().forEach(System.out::print);
    }
}
