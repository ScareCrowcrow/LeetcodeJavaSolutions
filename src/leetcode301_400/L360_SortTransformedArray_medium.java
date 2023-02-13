package leetcode301_400;

public class L360_SortTransformedArray_medium {
    // https://leetcode.cn/problems/sort-transformed-array/
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(a == 0) {
            for(int i = 0; i < nums.length; i++) {
                nums[i] = b * nums[i] + c;
            }
            if(b < 0) {
                reverse(nums, 0, nums.length - 1);
            }
            return  nums;
        }
        int[] res = new int[nums.length];
        double mid = (0.0 - b) / (a << 1);
        int rp = 0;
        while (rp < nums.length && nums[rp] < mid) {
            rp++;
        }
        int lp = rp - 1;
        int i = 0;
        while(lp >= 0 && rp < nums.length) {
            if((mid - nums[lp]) < (nums[rp] - mid)) {
                res[i] = a * nums[lp] * nums[lp] + b * nums[lp] + c;
                lp--;
            } else {
                res[i] = a * nums[rp] * nums[rp] + b * nums[rp] + c;
                rp++;
            }
            i++;
        }
        while(rp < nums.length) {
            res[i++] = a * nums[rp] * nums[rp] + b * nums[rp] + c;
            rp++;
        }
        while(lp >= 0) {
            res[i++] = a * nums[lp] * nums[lp] + b * nums[lp] + c;
            lp--;
        }
        if(a < 0) {
            reverse(res, 0, res.length - 1);
        }
        return res;
    }
    private void reverse(int[] nums, int i, int j) {
        while(i < j && nums[i] != nums[j]) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i++] ^= nums[j--];
        }
    }
}
