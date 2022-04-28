package leetcode001_100;

import java.util.LinkedList;
import java.util.List;

public class Problem022 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        helper("", res, n, 0, 0);
        return res;
    }

    public void helper(String curr, List<String> res, int n, int left, int right){
        /*
         * n: 括号对数
         * left: 左括号数
         * right: 右括号数
         * */
        if (right == n){
            res.add(curr);
            return;
        }
        if (left < n){
            helper(curr + "(", res, n, left + 1, right);
        }
        if (right < left){
            helper(curr + ")", res, n, left, right + 1);
        }
    }
}
