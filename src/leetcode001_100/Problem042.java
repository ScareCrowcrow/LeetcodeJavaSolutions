package leetcode001_100;

public class Problem042 {
    // https://leetcode-cn.com/problems/trapping-rain-water/
    public int trap(int[] arr) {
        // 只关注i位置的水量，水[i] = max(min(max(0...i-1), max(i+1...N-1)) - arr[i], 0)
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int N = arr.length;
        int L = 1;
        int leftMax = arr[0];
        int R = N - 2;
        int rightMax = arr[N - 1];
        int water = 0;
        while (L <= R) {
            if (leftMax <= rightMax) {
                water += Math.max(0, leftMax - arr[L]);
                leftMax = Math.max(leftMax, arr[L++]);
            } else {
                water += Math.max(0, rightMax - arr[R]);
                rightMax = Math.max(rightMax, arr[R--]);
            }
        }
        return water;
    }
}
