package leetcode301_400;

public class L387_FirstUniqueCharacterInAString_easy {
    // https://leetcode.cn/problems/first-unique-character-in-a-string/
    public int firstUniqChar(String s) {
        int[] counter = new int[26];
        for(char c: s.toCharArray()) {
            counter[c - 'a'] ++;
        }
        for(int i = 0; i < s.length(); i++) {
            if(counter[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
