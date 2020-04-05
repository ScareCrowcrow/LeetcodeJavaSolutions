package InterviewQuestions;

public class p19_hard {
    public boolean isMatch(String s, String p) {
        // 运用了回溯的思想：*与前一个字符串看作一个整体，考虑0、1、2...
        // 采用递归的解法
        if (s == null || p == null){
            return false;
        }
        return isMatch(s, s.length(), p, p.length());
    }

    boolean isMatch(String s, int i, String p, int j){
        if (j == 0) return i == 0;

        if (i == 0){
            return j > 1 && p.charAt(j - 1) == '*' && isMatch(s, i, p, j - 2);
        }

        if (p.charAt(j - 1) != '*'){
            return isMatch(s.charAt(i - 1), p.charAt(j - 1)) && isMatch(s, i - 1, p, j - 1);
        }

        return isMatch(s, i, p, j - 2) || isMatch(s, i - 1, p, j) && isMatch(s.charAt(i - 1), p.charAt(j - 2));
    }

    boolean isMatch(char a, char b){
        return a == b || b == '.';
    }
}
