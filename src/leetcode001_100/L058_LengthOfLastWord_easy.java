package leetcode001_100;

public class L058_LengthOfLastWord_easy {
    // https://leetcode.cn/problems/length-of-last-word/
    public int lengthOfLastWord(String s) {
        int ans = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' '){
                ans++;
            }else if(ans != 0) {
                return ans;
            }
        }
        return ans;
    }
}
