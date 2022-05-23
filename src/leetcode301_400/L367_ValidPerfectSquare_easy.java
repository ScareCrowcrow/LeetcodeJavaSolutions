package leetcode301_400;

public class L367_ValidPerfectSquare_easy {
    // https://leetcode.cn/problems/valid-perfect-square/
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            // int product = mid * mid;   越界
            int t = num / mid;
            if (t == mid) {
                if (num % mid == 0) return true;
                low = mid + 1;
            } else if (t < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
