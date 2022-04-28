package leetcode001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem015 {
    public static List<List<Integer>> threeSum(int[] nums) {
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
