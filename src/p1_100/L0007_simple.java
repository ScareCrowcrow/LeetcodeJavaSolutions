package p1_100;

public class L0007_simple {
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

    public static void main(String[] args) {
        int x = 120;
        System.out.println(reverse(x));
    }
}
