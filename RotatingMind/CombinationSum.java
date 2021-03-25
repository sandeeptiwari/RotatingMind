import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumCombination {

    public static void main(String...args){
        int arr[] = {2, 3, 6, 7};
        int target = 7;

        System.out.print(new SumCombination().possibleCombination(arr, target));
    }

    public List<List<Integer>> possibleCombination(int[] candidates, int target){

        List<List<Integer>> results = new ArrayList<>();

        //if candidates either null or size zero
        if(candidates == null || candidates.length == 0)
        {
            return results;
        }

        //sort the candidates into ascending order
         Arrays.sort(candidates);

        List<Integer> combinations = new ArrayList<>();
        findPossibleSumCombination(results, candidates, combinations, target, 0);

        return results;
    }

    public void findPossibleSumCombination(List<List<Integer>> results, int[] candidates,List<Integer> combinations, int target, int startIndex){

        //base condition
        if(target == 0){
            results.add(new ArrayList<>(combinations));
            return;
        }

        int len = candidates.length;

        for (int i = startIndex; i < len; i++) {
            int combination = candidates[i];
            if(target < combination)
                break;

            combinations.add(combination);
            findPossibleSumCombination(results, candidates, combinations, target - combination, i);
            combinations.remove(combinations.size() - 1);
        }
    }
}
