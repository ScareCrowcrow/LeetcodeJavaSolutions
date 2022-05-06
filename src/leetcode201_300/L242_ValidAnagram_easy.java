package leetcode201_300;

public class L242_ValidAnagram_easy {
    // https://leetcode-cn.com/problems/valid-anagram/
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++){
            counter[s.charAt(i) - 'a'] ++;
            counter[t.charAt(i) - 'a'] --;
        }

        for (int count : counter){
            if (count != 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        int[] count = new int[256];
        for (char cha : str1) {
            count[cha]++;
        }
        for (char cha : str2) {
            if (--count[cha] < 0) {
                return false;
            }
        }
        return true;
    }
}
