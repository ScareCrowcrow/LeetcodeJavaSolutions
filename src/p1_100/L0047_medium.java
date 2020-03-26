package p1_100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L0047_medium {
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        if (nums == null || nums.length == 0) return res;
        permuteHelper(nums, new boolean[nums.length], new LinkedList<Integer>(), res);
        return res;
    }

    private void permuteHelper(int[] nums, boolean[] used, List<Integer> curList, List<List<Integer>> res){
        if (curList.size() == nums.length) res.add(new LinkedList<>(curList));
        else{
            int preNum = nums[0] - 1;
            for (int i = 0; i < nums.length; i++){
                if (used[i] == false && (nums[i] != preNum)){
                    preNum = nums[i];
                    curList.add(nums[i]);
                    used[i] = true;
                    permuteHelper(nums, used, curList, res);
                    used[i] = false;
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }
}
