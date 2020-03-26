package InterviewQuestions;

public class p50_simple {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        int[] allChars = new int[256];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++){
            allChars[(int)(str[i])]++;
        }
        for (int i = 0; i < s.length(); i++){
            if (allChars[(int)str[i]] == 1){
                return str[i];
            }
        }
        return ' ';
    }
}
