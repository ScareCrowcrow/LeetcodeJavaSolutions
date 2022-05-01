package leetcode1001_1100;

public class Problem1081 {
    // 贪心
    // https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/
    public String smallestSubsequence(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i)]++;
        }
        int minACSIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            minACSIndex = str.charAt(minACSIndex) > str.charAt(i) ? i : minACSIndex;
            if (--map[str.charAt(i)] == 0) {
                break;
            }
        }
        // 0...break(之前) minACSIndex
        // str[minACSIndex] 剩下的字符串str[minACSIndex+1...] -> 去掉str[minACSIndex]字符 -> s'
        // s'...
        return String.valueOf(str.charAt(minACSIndex)) + smallestSubsequence(
                str.substring(minACSIndex + 1).replaceAll(String.valueOf(str.charAt(minACSIndex)), ""));
    }
}
