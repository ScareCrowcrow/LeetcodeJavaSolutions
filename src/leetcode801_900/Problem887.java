package leetcode801_900;

import java.util.HashMap;
import java.util.Map;

public class Problem887 {
    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }
    Map<Integer, Integer> memo = new HashMap<>();
    public int dp(int K, int N){
        if (!memo.containsKey(N * 100 + K)){
            int ans;
            if (N == 0)
                ans = 0;
            else if (K == 1){
                ans = N;
            }else {
                int lo = 1, hi = N;
                while (lo + 1 < hi){
                    int x = lo + (hi - lo) / 2;
                    // 鸡蛋碎了
                    int t1 = dp(K-1, x-1);
                    // 鸡蛋没碎
                    int t2 = dp(K, N - x);
                    if (t1 < t2){
                        lo = x;
                    }else if (t1 > t2){
                        hi = x;
                    }else lo = hi = x;
                }
                ans = 1 + Math.min(Math.max(dp(K-1, lo-1), dp(K, N-lo)),
                        Math.max(dp(K-1, hi-1), dp(K, N-hi)));
            }
            memo.put(N*100+K, ans);
        }
        return memo.get(N*100+K);
    }
}
