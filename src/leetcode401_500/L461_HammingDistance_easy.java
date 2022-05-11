package leetcode401_500;

public class L461_HammingDistance_easy {
    // https://leetcode.cn/problems/hamming-distance/
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int ans = 0;
        while(z > 0) {
            ans += z & 1;
            z >>= 1;
        }
        return ans;
    }
}
