package leetcode401_500;

public class Problem479 {
    public static int largestPalindrome1(int n) {
         if (n == 1) {
             return 9;
         }
         int upper = (int) Math.pow(10, n) - 1;
         int ans = 0;
         for (int left = upper; ans == 0; --left) { // 枚举回文数的左半部分
             long p = left;
             for (int x = left; x > 0; x /= 10) {
                 p = p * 10 + x % 10; // 翻转左半部分到其自身末尾，构造回文数 p
             }
             for (long x = upper; x * x >= p; --x) {
                 if (p % x == 0) { // x 是 p 的因子
                     ans = (int) (p % 1337);
                     break;
                 }
             }
         }
         return ans;
    }

    static long[] palindromes = {0, 9, 9009, 906609, 99000099, 9966006699L, 999000000999L, 99956644665999L, 9999000000009999L};
    public static int largestPalindrome2(int n) {
        return (int)(palindromes[n] % 1337);
    }
}
