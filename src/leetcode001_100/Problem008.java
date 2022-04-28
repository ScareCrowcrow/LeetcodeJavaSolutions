package leetcode001_100;

public class Problem008 {
    public static int myAtoi(String str) {
        String string = str.trim();
        char[] chars = string.toCharArray();
        int index = 0;
        if (chars.length == 0) return 0;
        boolean sign = true;
        if (chars[index] == '-'){
            sign = false;
            index++;
        }
        else if (chars[index] == '+'){
            index++;
        }else if (!Character.isDigit(chars[index])){
            return 0;
        }
        int res = 0;
        while (index < chars.length && Character.isDigit(chars[index])){
            int digit = chars[index] - '0';
            if (res > (Integer.MAX_VALUE - digit) / 10){
                return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            index++;
        }
        return sign ? res : -res;
    }
}
