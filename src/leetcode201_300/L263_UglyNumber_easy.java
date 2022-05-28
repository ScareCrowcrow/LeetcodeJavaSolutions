package leetcode201_300;

public class L263_UglyNumber_easy {
    // https://leetcode.cn/problems/ugly-number/
    public boolean isUgly(int n) {
        if(n < 1) return false;
        while(n % 5 == 0) {
            n /= 5;
        }
        while(n % 3 == 0) {
            n /= 3;
        }
        while(n % 2 == 0) {
            n >>= 1;
        }
        return n == 1;
    }
}
