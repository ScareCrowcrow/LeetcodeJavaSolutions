package leetcode501_600;

public class L557_ReverseWordsInAStringIII_easy {
    // https://leetcode.cn/problems/reverse-words-in-a-string-iii/
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            String res = reverseStr(strs[i]);
            if (i == strs.length - 1) {
                sb.append(res);
            } else {
                sb.append(res).append(" ");
            }
        }
        return sb.toString();
    }

    public String reverseStr(String str) {
        int left = 0, right = str.length() - 1;
        char[] chs = str.toCharArray();
        while (left < right) {
            char temp = chs[right];
            chs[right] = chs[left];
            chs[left] = temp;
            right--;
            left++;
        }
        return String.valueOf(chs);
    }
}
