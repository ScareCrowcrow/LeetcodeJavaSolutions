package leetcode1601_1700;

import java.util.Arrays;

public class L1619_MeanOfArrayAfterRemovingSomeElements_easy {
    // https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        double ans = 0;
        for(int i = arr.length/20; i < arr.length * 19/20; i++) {
            ans += arr[i];
        }
        return ans / (arr.length * 9 / 10);
    }
}
