package p1_100;

// 分治法

import java.util.Arrays;

public class L0087_hard {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        if (s1.length() == 1 && s1.equals(s2)) return true;
        char[] s1char = s1.toCharArray();
        char[] s2char = s2.toCharArray();
        Arrays.sort(s1char);
        Arrays.sort(s2char);
        String str1 = new String(s1char);
        String str2 = new String(s2char);
        if (!str1.equals(str2)){
            return false;
        }
        for (int length = 1; length < s1.length(); length++){
            String s1Left = s1.substring(0, length);
            String s1Right = s1.substring(length, s1.length());
            if ((isScramble(s1Left, s2.substring(0, length)) && isScramble(s1Right, s2.substring(length, s2.length()))) ||
                    (isScramble(s1Left, s2.substring(s2.length() - length, s2.length())) && isScramble(s1Right, s2.substring(0, s2.length() - length)))){
                return true;
            }
        }
        return false;
    }
}
