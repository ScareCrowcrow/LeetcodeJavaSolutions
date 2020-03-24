package p1_100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L0090_medium {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 对于每一位有两种选择，选或不选
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        subsetsHelper(nums, 0,true, result, new LinkedList<>());
        return result;
    }

    private void subsetsHelper(int[] nums, int currIdx, boolean taken, List<List<Integer>> result, List<Integer> curr){
        if (currIdx == nums.length) {
            result.add(new LinkedList<>(curr));
        }else {
            // not choose
            subsetsHelper(nums, currIdx+1, false, result, curr);
            // choose
            // 相等的两个元素，如果前一个元素上一轮not choose，后一个元素这一轮choose，会出现重复
            if (taken || nums[currIdx - 1] != nums[currIdx]){
                curr.add(nums[currIdx]);
                subsetsHelper(nums, currIdx+1,true, result, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
