package leetcode801_900;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L873_LengthOfLongestFibonacciSubsequence_medium {
    // https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int res = 0, sum;
        //dp[i][j]表示以A[i]、A[j]结尾的子序列的最大斐波那契数列长度
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 2);
        }
        int l = 0, r = 0;
        for(int i  = 1; i < n; i++) {
            l = 0;
            r = i - 1;
            while(l < r) {
                sum = arr[l] + arr[r];
                if(sum == arr[i]) {
                    dp[r][i] = Math.max(dp[r][i], dp[l][r] + 1);
                    res = Math.max(dp[r][i], res);
                    l++;
                    r--;
                }else if(sum < arr[i]) {
                    l++;
                }else {
                    r--;
                }
            }
        }
        return res;
    }

    public int lenLongestFibSubseq2(int[] arr) {
        int max = 0, n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) { // 得到值与下标的映射
            map.put(arr[i], i);
        }
        int[][] dp = new int[n - 1][n]; // i一定小于j，所以第一维大小可以设为n-1
        for(int i = 0; i < n; i++){
            for(int k = i + 2; k < n; k++){ // k至少比i大2，因为中间要放下j
                int j = map.getOrDefault(arr[k] - arr[i], -1); // 获取满足arr[i]+arr[j]=arr[k]的j，不满足时j=-1
                if(i < j && j < k) { // j在i和k之间
                    dp[j][k] = dp[i][j] + 1;
                    max = Math.max(max, dp[j][k]);
                }
            }
        }
        return max == 0 ? 0 : max + 2;
    }
}
