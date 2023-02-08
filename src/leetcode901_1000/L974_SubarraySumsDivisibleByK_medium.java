package leetcode901_1000;

public class L974_SubarraySumsDivisibleByK_medium {
    // https://leetcode.cn/problems/subarray-sums-divisible-by-k/
    /**
     * 考点：前缀和
     * 整体思路：
     * 将所有数变成K对应的余数
     *      处理方式：正数就为余数  负数就为 (余数 + K) % K
     *      通用方式: (num % K + K) % K 【不用区分正负数】
     *
     * 通过求余数前缀和的进行中若有相同的余数那么做差就存在被整除的结果：
     * 例如：index= 0 1 2 3 4  5  6 7
     *          A={1,2,3,4,5,-1,-2,3} K=3
     *   =>preMod={1,2,3,1,2, 2, 1,3}
     *   =>sumMod={1,0,0,1,0, 2, 0,0}
     *   => sum[0:1] % 3 = 0
     *      sum[0:2] % 3 = 0
     *      sum[1:2] % 3 = 0
     *
     *   => 当前内容中余数出现的个数就是满足的个数
     **/
    public int subarraysDivByK(int[] nums, int k) {
        // 存储前缀和出现余数的个数
        int[] modK = new int[k];
        // 当余数是0的时候，直接满足不用进行做差处理
        modK[0] = 1;

        int cnt = 0, preSum = 0;
        for (int num: nums) {
            preSum = ((preSum + num) % k + k) % k;
            // 查看有多少个余数相同的个数
            cnt += modK[preSum];
            modK[preSum]++;
        }
        return cnt;
    }
}
