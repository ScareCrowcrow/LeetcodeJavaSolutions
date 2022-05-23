package leetcode001_100;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class L046_Permutations_medium {
    // https://leetcode-cn.com/problems/permutations/
    // 记录所有全排列
    public List<List<Integer>> res = new LinkedList<>();
    public LinkedList<Integer> track = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return res;
    }

    // 回溯算法框架
    public void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            // 穷举完一个全排列
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i]))
                continue;
            // 前序遍历位置做选择
            track.add(nums[i]);
            backtrack(nums);
            // 后序遍历位置取消选择
            track.removeLast();
        }
    }
}
