package leetcode001_100;

public class Problem007 {
    public static int  reverse(int x) {
        int rev = 0;
        while (x != 0){
            int newrev = rev * 10 + x % 10;
            // check overflow
            if ((newrev - x % 10)/10 != rev){
                return 0;
            }
            rev = newrev;
            x /= 10;
        }
        return rev;
    }
}
