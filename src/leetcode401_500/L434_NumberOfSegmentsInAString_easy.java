package leetcode401_500;

public class L434_NumberOfSegmentsInAString_easy {
    // https://leetcode.cn/problems/number-of-segments-in-a-string/
    public int countSegments(String s) {
        if(s == null || s.equals("")) {
            return 0;
        }
        int ans = 0;
        String[] str = s.split(" ");
        for(String s1: str) {
            if(!" ".equals(s1) && !"".equals(s1)) {
                ans++;
            }
        }
        return ans;
    }
}
