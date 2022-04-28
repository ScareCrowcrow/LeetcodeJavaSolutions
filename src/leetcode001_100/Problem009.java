package leetcode001_100;

public class Problem009 {
    public static boolean isPalindrome(int x) {
        /*
         * 采用字符转检测回文的方式
         * */
        char[] c = Integer.toString(x).toCharArray();
        int i = 0;
        int j = c.length - 1;
        while (i < j){
            if (c[i] != c[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        // 采用数学的方式
        if (x < 0) return false;
        // 最高位
        int div = 1;
        int num = x;
        while (num / div >= 10){
            div *= 10;
        }
        while (num != 0){
            int left = num/div;
            int right = num % 10;
            if (left != right) return false;
            num = (num - left * div) / 10;
            div /= 100;
        }
        return true;
    }
}
