package leetcode201_300;

import java.util.HashMap;
import java.util.Map;

public class L290_WordPattern_easy {
    // https://leetcode.cn/problems/word-pattern/
    public boolean wordPattern(String pattern, String s) {
        if(pattern == null || s == null) return false;
        String[] str = s.split(" ");
        if(pattern.length() != str.length) {
            return false;
        }
        Map<Character, String> chrToStr = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            if(chrToStr.containsKey(pattern.charAt(i))) {
                if(!chrToStr.get(pattern.charAt(i)).equals(str[i])) {
                    return false;
                }
            }else {
                if(chrToStr.containsValue(str[i])) {
                    return false;
                }else {
                    chrToStr.put(pattern.charAt(i), str[i]);
                }
            }
        }
        return true;
    }
}
