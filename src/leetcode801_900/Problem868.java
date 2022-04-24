package leetcode801_900;

public class Problem868 {
    public int binaryGap(int n) {
        int pre = -1, ans = 0;
        for(int i = 0; i < 30; i++) {
            if(((n >> i) & 1) != 0) {
                if(pre != -1){
                    ans = Math.max(i - pre, ans);
                }
                pre = i;
            }
        }
        return ans;
    }
}
