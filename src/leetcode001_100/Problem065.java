package leetcode001_100;

public class Problem065 {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        int i = 0;
        int n = s.length();
        // skip whitespace
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        // check +/- sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        // check digits
        boolean isDigits = false;
        while (i < n && Character.isDigit(s.charAt(i))){
            i++;
            isDigits = true;
        }
        // check post . parts
        if (i < n && s.charAt(i) == '.'){
            i++;
            while (i < n && Character.isDigit(s.charAt(i))){
                isDigits = true;
                i++;
            }
        }
        // check exponent
        if (i < n && s.charAt(i) == 'e' && isDigits){
            i++;
            isDigits = false;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            while (i < n && Character.isDigit(s.charAt(i))){
                i++;
                isDigits = true;
            }
        }
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        return isDigits && i == s.length();
    }
}
