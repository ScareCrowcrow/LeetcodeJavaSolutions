package leetcode1501_1600;

public class Problem1539 {
    // https://leetcode-cn.com/problems/kth-missing-positive-number/
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] - i - 1 >= k) {
                return k + i;
            }
        }
        return k + n;
    }
}
