package p1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L0040_medium {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target == 0) return results;
        Arrays.sort(candidates);
        combinationHelper(candidates, target, 0, results, new ArrayList<>());
        return results;
    }

    private void combinationHelper(int[] candidates, int target, int index, List<List<Integer>> results, List<Integer> curSeq){
        if (target == 0){
            results.add(new ArrayList<Integer>(curSeq));
        }else if (target > 0){
            for (int i = index; i < candidates.length; i++){
                if (i != index && candidates[i] == candidates[i-1]) continue;
                if (candidates[i] > target) break;
                curSeq.add(candidates[i]);
                combinationHelper(candidates, target - candidates[i], i + 1, results, curSeq);
                curSeq.remove(curSeq.size() - 1);
            }
        }
    }
}
