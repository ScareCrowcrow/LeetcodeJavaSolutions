package p1_100;

// TAG: 二分法

public class L0069_simple {
    public int mySqrt(int x) {
        // 二分法
        if (x <= 0) return 0;
        int magicNum = (int)Math.sqrt(Integer.MAX_VALUE);
        int start = 1, end = magicNum;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (mid * mid == x) return mid;
            if (mid * mid > x) end = mid;
            else start = mid;
        }
        if (end * end <= x) return end;
        else return start;
    }

    public int mySqrt2(int x) {
        // 规律:等差数列
        int cur = 0;
        int res = 0;
        int add = 1;
        while (cur <= x){
            if (Integer.MAX_VALUE - cur < add) return res;
            cur += add;
            res++;
            add += 2;
        }
        return res - 1;
    }
}
