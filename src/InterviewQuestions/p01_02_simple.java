package InterviewQuestions;

public class p01_02_simple {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        int result = 0;
        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();
        int len = s1Char.length;
        for (int i = 0; i < len; i++){
            result = result ^ s1Char[i] ^ s2Char[i];
        }
        return result == 0;
    }
}
