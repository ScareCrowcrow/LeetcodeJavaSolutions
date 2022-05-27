package leetcode301_400;

public class L383_RansomNote_easy {
    // https://leetcode.cn/problems/ransom-note/
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] counter = new int[26];
        for(int i = 0; i < ransomNote.length(); i++) {
            counter[ransomNote.charAt(i) - 'a'] ++;
        }
        for(int j = 0; j < magazine.length(); j++) {
            counter[magazine.charAt(j) - 'a'] --;
        }
        for(int count: counter) {
            if(count > 0) {
                return false;
            }
        }
        return true;
    }
}
