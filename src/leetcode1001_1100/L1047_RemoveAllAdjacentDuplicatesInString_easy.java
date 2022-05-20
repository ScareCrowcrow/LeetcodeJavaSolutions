package leetcode1001_1100;

public class L1047_RemoveAllAdjacentDuplicatesInString_easy {
    // https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
    public String removeDuplicates(String s) {
        char[] strs = s.toCharArray();
        int index = -1;
        for(int i = 0; i < strs.length; i++) {
            if(index >= 0 && strs[index] == strs[i]) {
                index--;
            }else{
                index++;
                strs[index] = strs[i];
            }
        }
        return String.copyValueOf(strs, 0, index+1);
    }
}
