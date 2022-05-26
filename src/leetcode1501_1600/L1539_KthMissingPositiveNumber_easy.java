package leetcode1501_1600;

public class L1539_KthMissingPositiveNumber_easy {
    // https://leetcode-cn.com/problems/kth-missing-positive-number/
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 根据每个位置缺失的数考虑
            if (arr[i] - i - 1 >= k) {
                return k + i;
            }
        }
        return k + n;
    }
}
