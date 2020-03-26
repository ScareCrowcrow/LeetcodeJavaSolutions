package InterviewQuestions;

public class p58_I_simple {
    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) return "";
        s = s.trim();
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--){
            if (str[i].trim().length() > 0){
                sb.append(str[i] + " ");
            }
        }
        return sb.toString().trim();
    }
}
