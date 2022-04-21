package leetcode001_100;

public class Problem003 {
    /*
    * 方法有2种：
    * 方法1: 动态规划，以i结尾
    * 方法2: 滑动窗口
    * */
    // dp
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] str = s.toCharArray();
        // 当前字符上次出现的位置
        int[] map = new int[128];
        for (int i = 0; i < 128; i++) {
            map[i] = -1;
        }
        map[str[0]] = 0;
        int N = str.length;
        int ans = 1;
        // 前一个字符往左推的距离
        int pre = 1;
        for (int i = 1; i < N; i++) {
            pre = Math.min(i - map[str[i]], pre + 1);
            ans = Math.max(ans, pre);
            map[str[i]] = i;
        }
        return ans;
    }

    // 滑动窗口
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0, right = 0;
        int n = s.length();
        // ASCII码一共有128个
        boolean[] used = new boolean[128];
        int max = 0;
        while (right < n){
            if (used[s.charAt(right)] == false){
                // 无重复字符右指针继续向前滑动
                used[s.charAt(right)] = true;
                right++;
            }else{
                max = Math.max(max, right - left);
                while (left < right && s.charAt(right) != s.charAt(left)){
                    used[s.charAt(left)] = false;
                    left++;
                }
                // 当left和right指向的是同一字符
                left++;
                right++;
            }
        }
        max = Math.max(max, right - left);
        return max;
    }
}