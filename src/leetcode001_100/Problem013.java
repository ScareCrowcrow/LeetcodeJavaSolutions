package leetcode001_100;

public class Problem013 {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int result = 0;
        if (s.contains("CM")) result -= 200;
        if (s.contains("CD")) result -= 200;
        if (s.contains("XC")) result -= 20;
        if (s.contains("XL")) result -= 20;
        if (s.contains("IX")) result -= 2;
        if (s.contains("IV")) result -= 2;
        for (char c: s.toCharArray()){
            if (c == 'M') result += 1000;
            else if (c == 'D') result += 500;
            else if (c == 'C') result += 100;
            else if (c == 'L') result += 50;
            else if (c == 'X') result += 10;
            else if (c == 'V') result += 5;
            else if (c == 'I') result += 1;
        }
        return result;
    }
}
