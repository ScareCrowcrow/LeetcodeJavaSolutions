package leetcode001_100;

public class L013_RomanToInteger_easy {
    // https://leetcode-cn.com/problems/roman-to-integer/
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

    public static int romanToInt2(String s) {
        // C     M     X   C     I   X
        // 100  1000  10   100   1   10
        int nums[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'I':
                    nums[i] = 1;
                    break;
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                sum -= nums[i];
            } else {
                sum += nums[i];
            }
        }
        return sum + nums[nums.length - 1];
    }
}
