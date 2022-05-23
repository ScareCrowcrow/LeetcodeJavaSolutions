package leetcode201_300;

import java.util.HashMap;
import java.util.Map;

public class L246_StrobogrammaticNumber_easy {
    // https://leetcode.cn/problems/strobogrammatic-number/
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('1', '1');
        map.put('8', '8');
        map.put('0', '0');
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            if (map.get(num.charAt(left)) == null || map.get(num.charAt(right)) == null) {
                return false;
            }
            if (map.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
