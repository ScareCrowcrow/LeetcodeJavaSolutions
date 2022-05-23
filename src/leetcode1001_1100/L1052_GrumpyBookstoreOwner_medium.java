package leetcode1001_1100;

public class L1052_GrumpyBookstoreOwner_medium {
    // https://leetcode.cn/problems/grumpy-bookstore-owner/
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = grumpy.length;
        // 前缀和 preSum[i] 表示 [0..i) 里因为老板生气而感到不开心的顾客数
        int[] preSum = new int[len + 1];

        // 统计 1. 所有本来就不生气的顾客数量；2. 前缀和数组
        int originCount = 0;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                // 不生气
                originCount += customers[i];
                preSum[i + 1] = preSum[i];
            } else {
                // 生气时候前缀和
                preSum[i + 1] = preSum[i] + customers[i];
            }
        }

        int maxAngryCount = 0;
        // 固定长度的滑动窗口的左边界：[i..i + X)
        for (int left = 0; left < len - X + 1; left++) {
            maxAngryCount = Math.max(maxAngryCount, preSum[left + X] - preSum[left]);
        }
        // 所有本来就不生气的顾客
        return originCount + maxAngryCount;
    }
}
