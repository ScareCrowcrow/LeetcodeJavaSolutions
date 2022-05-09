package leetcode901_1000;

public class L942_DIStringMatch_easy {
    // https://leetcode-cn.com/problems/di-string-match/
    public int[] diStringMatch(String s) {
        int left = 0, right = s.length();
        int[] ans = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'I') {
                ans[i] = left;
                left++;
            }else{
                ans[i] = right;
                right--;
            }
        }
        ans[s.length()] = left;
        return ans;
    }
}
