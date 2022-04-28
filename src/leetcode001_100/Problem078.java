package leetcode001_100;

import java.util.LinkedList;
import java.util.List;

public class Problem078 {
    public List<List<Integer>> subsets(int[] nums) {
        // 回溯
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) return result;
        subsetsHelper(nums, 0, result, new LinkedList<>());
        return result;
    }

    private void subsetsHelper(int[] nums, int currIdx, List<List<Integer>> result, List<Integer> curr){
        result.add(new LinkedList<>(curr));
        for (int idx = currIdx; idx < nums.length; idx++){
            curr.add(nums[idx]);
            subsetsHelper(nums, idx+1, result, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        // 对于每一位有两种选择，选或不选
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) return result;
        subsetsHelper2(nums, 0, result, new LinkedList<>());
        return result;
    }

    private void subsetsHelper2(int[] nums, int currIdx, List<List<Integer>> result, List<Integer> curr){
        if (currIdx == nums.length) {
            result.add(new LinkedList<>(curr));
        }else {
            // not choose
            subsetsHelper2(nums, currIdx+1, result, curr);
            // choose
            curr.add(nums[currIdx]);
            subsetsHelper2(nums, currIdx+1, result, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
