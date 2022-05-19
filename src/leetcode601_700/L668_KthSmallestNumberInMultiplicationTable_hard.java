package leetcode601_700;

public class L668_KthSmallestNumberInMultiplicationTable_hard {
    // https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while(l < r) {
            int mid = l + ((r - l) >> 1);
            if(countLess(m, n, mid) < k) {
                l = mid + 1;
            }else{
                r = mid;
            }
            if (l == r - 1) {
                if(countLess(m, n, l) >= k) {
                    r = l;
                }
                break;
            }
        }
        return r;
    }

    public int countLess(int m, int n, int max) {
        int ans = 0;
        int r = m;
        for(int i = 1; i <= n; i++) {
            while(r > 0 && i * r > max) {
                r--;
            }
            ans += r;
        }
        return ans;
    }
}
