package leetcode001_100;

public class L066_PlusOne_easy {
    // https://leetcode-cn.com/problems/plus-one/
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // 全是9才会发生进位
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
