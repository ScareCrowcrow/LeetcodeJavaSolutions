package leetcode301_400;

public class L395_LongestSubstringWithAtLeastKRepeatingCharacters_medium {
    // https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
    public static int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int N = str.length;
        int max = 0;
        for (int require = 1; require <= 26; require++) {
            // 3种
            // a~z 出现次数
            int[] count = new int[26];
            // 目前窗口内收集了几种字符了
            int collect = 0;
            // 目前窗口内出现次数>=k次的字符，满足了几种
            int satisfy = 0;
            // 窗口右边界
            int R = -1;
            for (int L = 0; L < N; L++) { // L要尝试每一个窗口的最左位置
                // [L..R] R+1
                while (R + 1 < N && !(collect == require && count[str[R + 1] - 'a'] == 0)) {
                    R++;
                    if (count[str[R] - 'a'] == 0) {
                        collect++;
                    }
                    if (count[str[R] - 'a'] == k - 1) {
                        satisfy++;
                    }
                    count[str[R] - 'a']++;
                }
                // [L...R]
                if (satisfy == require) {
                    max = Math.max(max, R - L + 1);
                }
                // L++
                if (count[str[L] - 'a'] == 1) {
                    collect--;
                }
                if (count[str[L] - 'a'] == k) {
                    satisfy--;
                }
                count[str[L] - 'a']--;
            }
        }
        return max;
    }
}
