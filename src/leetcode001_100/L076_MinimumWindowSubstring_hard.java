package leetcode001_100;

public class L076_MinimumWindowSubstring_hard {
    // https://leetcode-cn.com/problems/minimum-window-substring/
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        int matchCount = 0;
        String res = "";
        // ASCII码字符共256个
        int[] tArr = new int[256];
        for (char c: t.toCharArray()){
            tArr[c]++;
        }
        int[] sArr = new int[256];
        int left = findNextStrIdx(0, s, tArr);
        if (left == s.length()) return "";
        int right = left;
        while (right < s.length()){
            int rightChar = s.charAt(right);
            if (sArr[rightChar] < tArr[rightChar]){
                matchCount++;
            }
            sArr[rightChar]++;
            while (left < s.length() && matchCount == t.length()){
                if (res.isEmpty() || res.length() > right - left + 1){
                    res = s.substring(left, right + 1);
                }
                int leftChar = s.charAt(left);
                if (sArr[leftChar] <= tArr[leftChar]){
                    matchCount--;
                }
                sArr[leftChar]--;
                left = findNextStrIdx(left + 1, s, tArr);
            }
            right = findNextStrIdx(right + 1, s, tArr);
        }
        return res;
    }

    private int findNextStrIdx(int start, String s, int[] tArr){
        while (start < s.length()){
            char c = s.charAt(start);
            if (tArr[c] != 0) return start;
            start++;
        }
        return start;
    }

    public String minWindow2(String s, String t) {
        // 有效还款，无效还款
        if (s.length() < t.length()) {
            return "";
        }
        char[] str = s.toCharArray();
        char[] target = t.toCharArray();
        int[] map = new int[256];
        for (char cha : target) {
            map[cha]++;
        }
        int all = target.length;
        int L = 0;
        int R = 0;
        int minLen = Integer.MAX_VALUE;
        int ansl = -1;
        int ansr = -1;
        while (R != str.length) {
            map[str[R]]--;
            if (map[str[R]] >= 0) {
                all--;
            }
            if (all == 0) {
                while (map[str[L]] < 0) {
                    map[str[L++]]++;
                }
                if (minLen > R - L + 1) {
                    minLen = R - L + 1;
                    ansl = L;
                    ansr = R;
                }
                all++;
                map[str[L++]]++;
            }
            R++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(ansl, ansr + 1);
    }
}
