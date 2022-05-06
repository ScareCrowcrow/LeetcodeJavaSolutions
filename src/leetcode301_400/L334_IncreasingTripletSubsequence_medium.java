package leetcode301_400;

public class L334_IncreasingTripletSubsequence_medium {
    // https://leetcode-cn.com/problems/increasing-triplet-subsequence/
    public static boolean increasingTriplet(int[] nums) {
        if(lengthOfLIS(nums) >= 3) {
            return true;
        }
        return false;
    }

    public static int lengthOfLIS(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] ends = new int[arr.length];
        // ends[i]表示目前所有长度为i+1的递增子序列的最小结尾
        // 返回ends数组的有效长度+1即为最长递增子序列的长度
        ends[0] = arr[0];
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = arr[i];
            max = Math.max(max, l + 1);
        }
        return max;
    }
}
