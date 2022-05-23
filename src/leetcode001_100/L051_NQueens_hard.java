package leetcode001_100;

import java.util.ArrayList;
import java.util.List;

public class L051_NQueens_hard {
    // https://leetcode.cn/problems/n-queens/
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n < 1) {
            return ans;
        }
        int[] record = new int[n];
        process1(0, record, n, ans);
        return ans;
    }

    // 当前来到i行，一共是0~N-1行
    // 在i行上放皇后，所有列都尝试
    // 必须要保证跟之前所有的皇后不打架
    // int[] record record[x] = y 之前的第x行的皇后，放在了y列上
    // 返回：不关心i以上发生了什么，i.... 后续有多少合法的方法数
    public static int process1(int i, int[] record, int n, List<List<String>> ans) {
        if (i == n) {
            gen(record, ans);
        }
        int res = 0;
        // i行的皇后，放哪一列呢？j列，
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n, ans);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j) {
        // 0..i-1
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    public static void gen(int[] record, List<List<String>> ans) {
        List<String> one_chance = new ArrayList<>();
        for(int i = 0; i < record.length; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < record.length; j++) {
                if(record[i] == j) {
                    s.append("Q");
                }else{
                    s.append(".");
                }
            }
            one_chance.add(s.toString());
        }
        ans.add(one_chance);
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }


}
