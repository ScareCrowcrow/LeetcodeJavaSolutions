package leetcode001_100;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class L046_Permutations_medium {
    // https://leetcode-cn.com/problems/permutations/
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        permuteHelper(res, new LinkedList<>(), nums, new HashSet<>());
        return res;
    }

    private void permuteHelper(List<List<Integer>> res, List<Integer> clist, int[] nums, HashSet<Integer> set){
        if (clist.size() == nums.length) res.add(new LinkedList<>(clist));
        else{
            for (int i = 0; i < nums.length; i++){
                if (!set.contains(nums[i])){
                    clist.add(nums[i]);
                    int last = clist.size() - 1;
                    set.add(nums[i]);
                    permuteHelper(res, clist, nums, set);
                    set.remove(nums[i]);
                    clist.remove(last);
                }
            }
        }
    }
}
