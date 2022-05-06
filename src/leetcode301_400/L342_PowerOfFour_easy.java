package leetcode301_400;

public class L342_PowerOfFour_easy {
    // https://leetcode-cn.com/problems/power-of-four/
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n&(-n)) == n && (n&0x55555555) != 0;
        // return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }
}
