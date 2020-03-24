package p1_100;

import java.util.ArrayList;

// TAG: 阶乘

public class L0060_medium {
    public String getPermutation(int n, int k) {
        char[] result = new char[n];
        ArrayList<Integer> nums = new ArrayList<>();
        int[] factorial = new int[n];
        factorial[0] = 1;
        // 阶乘：分组，得到每一组的个数
        for (int i = 1; i < n; i++){
            factorial[i] = factorial[i - 1] * i;
        }
        // 可用数组
        for (int i = 1; i <= n; i++){
            nums.add(i);
        }
        // 转化为index
        k--;
        for (int i = 0; i < n; i++){
            result[i] = Character.forDigit(nums.remove(k/factorial[n-1-i]), 10);
            k = k % factorial[n - 1 -i];
        }
        return new String(result);
    }
}
