package p1_100;

// 回溯

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L0039_medium {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                if (candidates[i] > target) break;
                curSeq.add(candidates[i]);
                combinationHelper(candidates, target - candidates[i], i, results, curSeq);
                curSeq.remove(curSeq.size() - 1);
            }
        }
    }
}
