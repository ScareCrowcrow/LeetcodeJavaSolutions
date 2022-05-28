package leetcode101_200;

public class L137_SingleNumberII_medium {
    // https://leetcode.cn/problems/single-number-ii/
    public int singleNumber(int[] nums) {
        int[] t = new int[32];
        for (int num: nums) {
            for (int i = 0; i < 32; i++) {
                t[i] += (num >> i) & 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if(t[i] % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
