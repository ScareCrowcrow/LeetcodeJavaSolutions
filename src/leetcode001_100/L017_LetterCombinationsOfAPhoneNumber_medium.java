package leetcode001_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class L017_LetterCombinationsOfAPhoneNumber_medium {
    // https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
    public static List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) return res;
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        //dfs("", 0, digits, res, map);
        bfs(digits, res, map);
        return res;
    }

    public static void dfs(String curr, int currIdx, String digits, List<String> res, HashMap<Character, char[]> map){
        if (currIdx == digits.length()){
            res.add(curr);
        }else{
            char c = digits.charAt(currIdx);
            if (map.containsKey(c)){
                for (char ch: map.get(c)){
                    dfs(curr + ch, currIdx + 1, digits, res, map);
                }
            }
        }
    }

    public static void bfs(String digits, List<String> res, HashMap<Character, char[]> map){
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            char[] letters = map.get(digits.charAt(i));
            int n = res.size();
            for (int j = 0; j < n; j++) {
                String temp = res.remove(0);
                for (int k = 0; k < letters.length; k++) {
                    res.add(temp + letters[k]);
                }
            }
        }
    }

    public static char[][] phone = {
            { 'a', 'b', 'c' }, // 2    0
            { 'd', 'e', 'f' }, // 3    1
            { 'g', 'h', 'i' }, // 4    2
            { 'j', 'k', 'l' }, // 5    3
            { 'm', 'n', 'o' }, // 6
            { 'p', 'q', 'r', 's' }, // 7
            { 't', 'u', 'v' },   // 8
            { 'w', 'x', 'y', 'z' }, // 9
    };

    // "23"
    public static List<String> letterCombinations2(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        char[] str = digits.toCharArray();
        char[] path = new char[str.length];
        process(str, 0, path, ans);
        return ans;
    }
    // 深度优先遍历
    public static void process(char[] str, int index, char[] path, List<String> ans) {
        if (index == str.length) {
            ans.add(String.valueOf(path));
        } else {
            char[] cands = phone[str[index] - '2'];
            for (char cur : cands) {
                path[index] = cur;
                process(str, index + 1, path, ans);
            }
        }
    }
}
