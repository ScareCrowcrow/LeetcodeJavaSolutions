package leetcode101_200;

public class Problem191 {
    public int hammingWeight(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            if(((n >> i) & 1) != 0) {
                ans++;
            }
        }
        return ans;
    }
}
