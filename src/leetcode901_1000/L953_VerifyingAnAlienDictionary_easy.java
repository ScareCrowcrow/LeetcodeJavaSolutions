package leetcode901_1000;

public class L953_VerifyingAnAlienDictionary_easy {
    // https://leetcode.cn/problems/verifying-an-alien-dictionary/
    public boolean isAlienSorted(String[] words, String order) {
        int[] alphaIndex = new int[26];
        for(int i = 0; i < order.length(); i++) {
            alphaIndex[order.charAt(i) - 'a'] = i;
        }
        for(int i = 1; i < words.length; i++) {
            boolean isValid = false;
            for(int j = 0; j < Math.min(words[i-1].length(), words[i].length()); j++){
                int pre = alphaIndex[words[i-1].charAt(j) - 'a'];
                int cur = alphaIndex[words[i].charAt(j) - 'a'];
                if(pre < cur) {
                    isValid = true;
                    break;
                } else if(pre > cur) {
                    return false;
                }
            }
            // words[i]与words[i-1]的前Math.min(words[i].length(), words[i-1].length())个字符都一样，此时字符串长的字典序大
            if(!isValid) {
                if(words[i-1].length() > words[i].length()) {
                    return false;
                }
            }
        }
        return true;
    }
}
