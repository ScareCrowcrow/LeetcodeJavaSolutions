package InterviewQuestions;

public class p58_II_simple {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        if (n >= len) return s;
        return s.substring(n, len) + s.substring(0, n);
    }
}
