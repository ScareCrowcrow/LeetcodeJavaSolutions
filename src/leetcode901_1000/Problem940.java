package leetcode901_1000;

import java.util.HashMap;

public class Problem940 {
    public int distinctSubseqII(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int m = 1000000007;
        char[] str = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int all = 1; // 一个字符也没遍历的时候，有空集
        for (char x : str) {
            int newAdd = all;
            // int curAll = all + newAdd - (map.containsKey(x) ? map.get(x) : 0);
            int curAll = all;
            curAll = (curAll + newAdd) % m;
            curAll = (curAll - map.getOrDefault(x, 0) + m) % m;
            all = curAll;
            map.put(x, newAdd);
        }
        return all - 1;
    }
}
