package leetcode1901_2000;

public class Problem1979 {
    public int findGCD(int[] nums) {
        if(nums == null || nums.length < 2) {
            return -1;
        }
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return gcd(max, min);
    }

    public int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
