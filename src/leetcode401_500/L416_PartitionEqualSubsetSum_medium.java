package leetcode401_500;

public class L416_PartitionEqualSubsetSum_medium {
    // https://leetcode.cn/problems/partition-equal-subset-sum/
    public static boolean canPartition1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) != 0) {
            return false;
        }
        return process(nums, 0, sum / 2) == sum / 2;
    }

    // arr[i...]可以自由选择，请返回累加和尽量接近rest，但不能超过rest的情况下，最接近的累加和是多少？
    public static int process(int[] arr, int i, int rest) {
        if (i == arr.length) {
            return 0;
        } else { // 还有数，arr[i]这个数
            // 可能性1，不使用arr[i]
            int p1 = process(arr, i + 1, rest);
            // 可能性2，要使用arr[i]
            int p2 = 0;
            if (arr[i] <= rest) {
                p2 = arr[i] + process(arr, i + 1, rest - arr[i]);
            }
            return Math.max(p1, p2);
        }
    }

    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) != 0) {
            return false;
        }
        sum /= 2;
        int N = nums.length;
        int[][] dp = new int[N + 1][sum + 1];
        for (int i = N - 1; i >= 0; i--) {
            for (int rest = 0; rest <= sum; rest++) {
                // 可能性1，不使用arr[i]
                int p1 = dp[i + 1][rest];
                // 可能性2，要使用arr[i]
                int p2 = 0;
                if (nums[i] <= rest) {
                    p2 = nums[i] + dp[i + 1][rest - nums[i]];
                }
                dp[i][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][sum] == sum;
    }
}
