package leetcode001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L015_ThreeSum_medium {
    // https://leetcode.cn/problems/3sum/
    // 在twoSum的基础上改造
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = N - 1; i > 1; i--) { // 三元组最后一个数，是arr[i]   之前....二元组 + arr[i]
            if (i == N - 1 || nums[i] != nums[i + 1]) {
                List<List<Integer>> nexts = twoSum(nums, i - 1, -nums[i]);
                for (List<Integer> cur : nexts) {
                    cur.add(nums[i]);
                    ans.add(cur);
                }
            }
        }
        return ans;
    }

    // nums[0...end]这个范围上，有多少个不同二元组，相加==target，全返回
    // {-1,5}     K = 4
    // {1, 3}
    public static List<List<Integer>> twoSum(int[] nums, int end, int target) {
        int L = 0;
        int R = end;
        List<List<Integer>> ans = new ArrayList<>();
        while (L < R) {
            if (nums[L] + nums[R] > target) {
                R--;
            } else if (nums[L] + nums[R] < target) {
                L++;
            } else { // nums[L] + nums[R] == target
                if (L == 0 || nums[L - 1] != nums[L]) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[L]);
                    cur.add(nums[R]);
                    ans.add(cur);
                }
                L++;
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 2) return res;
        int n = nums.length;
        int i = 0;
        // O(nlogn)
        Arrays.sort(nums);
        while (i < n - 2){
            // 三指针
            int base = nums[i];
            int left = i + 1;
            int right = n - 1;
            // O(n^2)
            while (left < right){
                int sum = base + nums[left] + nums[right];
                if (sum == 0){
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(base);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    left = moveRight(nums, left + 1);
                    right = moveLeft(nums, right - 1);
                }else if (sum > 0){
                    right = moveLeft(nums, right - 1);
                }else {
                    left = moveRight(nums, left + 1);
                }
            }
            i = moveRight(nums, i + 1);
        }
        return res;
    }

    public static int moveLeft(int[] nums, int right){
        while (right == nums.length - 1 || (right >= 0 && nums[right] == nums[right+1])){
            right--;
        }
        return right;
    }

    public static int moveRight(int[] nums, int left){
        while (left == 0 || (left < nums.length && nums[left] == nums[left - 1])){
            left++;
        }
        return left;
    }
}
