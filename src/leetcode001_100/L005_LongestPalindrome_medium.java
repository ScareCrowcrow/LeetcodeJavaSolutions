package leetcode001_100;

public class L005_LongestPalindrome_medium {
    // https://leetcode.cn/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    // 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
    String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 双指针，向两边展开
            l--; r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }

    // 动态规划：范围上尝试模型
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return s;
        int len = s.length();
        char[] sChar = s.toCharArray();
        int start = 0;
        int length = 1;
        boolean[][] isPalindrome = new boolean[len][len];
        for (int i = 0; i < len; i++){
            isPalindrome[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++){
            if (sChar[i] == s.charAt(i+1)){
                isPalindrome[i][i+1] = true;
                start = i;
                length = 2;
            }
        }

        for (int i = 3; i <= len; i++){
            for (int j = 0; j + i - 1 < len; j++){
                if (sChar[j] == sChar[j+i-1] && isPalindrome[j+1][j+i-2]){
                    isPalindrome[j][j+i-1] = true;
                    start = j;
                    length = i;
                }
            }
        }
        return s.substring(start, start + length);
    }
}
