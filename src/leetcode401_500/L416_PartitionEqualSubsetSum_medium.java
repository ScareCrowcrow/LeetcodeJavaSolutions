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

    public boolean canPartition3(int[] nums) {
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
        sum >>= 1;
        int N = nums.length;
        boolean[][] dp = new boolean[N][sum + 1];
        for (int i = 0; i < N; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= sum) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i] >= 0) {
                    dp[i][j] |= dp[i - 1][j - nums[i]];
                }
            }
            if (dp[i][sum]) {
                return true;
            }
        }
        return false;
    }
}
